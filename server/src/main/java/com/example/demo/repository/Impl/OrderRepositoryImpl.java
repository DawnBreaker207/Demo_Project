package com.example.demo.repository.Impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.example.demo.config.Status;
import com.example.demo.dto.order.OrderItemDTO;
import com.example.demo.dto.order.OrderQueryRequestDTO;
import com.example.demo.dto.order.OrderRequestDTO;
import com.example.demo.dto.order.OrderResponseDTO;
import com.example.demo.model.Orders;
import com.example.demo.repository.OrderRepository;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

    private final DataSource dataSource;

    public OrderRepositoryImpl(DataSource dataSource) {
	this.dataSource = dataSource;
    }

    @Override
    public List<Orders> getAll() throws SQLException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public List<OrderResponseDTO> getAll(OrderQueryRequestDTO query) throws SQLException {
	List<OrderResponseDTO> orders = new ArrayList<>();
	StringBuilder sql = new StringBuilder(
		"SELECT o.id AS order_id, o.total, o.created_at, o.status AS order_status, "
			+ "c.name AS customer_name, s.status AS shipment_status, s.amount AS shipment_amout "
			+ "FROM orders o " + "JOIN customer c ON o.customer_id = c.id "
			+ "JOIN shipment s ON o.shipment_id = s.id " + "WHERE o.is_delete = 0");

	List<Object> params = new ArrayList<>();

	if (query != null) {

	    if (query.getCustomerName() != null) {
		sql.append(" AND c.name LIKE ?");
		params.add("%" + query.getCustomerName() + "%");
	    }

	    if (query.getOrderStatus() != null) {
		sql.append(" AND o.status = ?");
		params.add(query.getOrderStatus().name());
	    }

	    if (query.getShipmentStatus() != null) {
		sql.append(" AND s.status = ?");
		params.add(query.getShipmentStatus().name());
	    }

	    if (query.getMinTotal() != null) {
		sql.append(" AND o.total >= ?");
		params.add(query.getMinTotal());
	    }

	    if (query.getMaxTotal() != null) {
		sql.append(" AND o.total <= ?");
		params.add(query.getMaxTotal());
	    }

	    if (query.getCreateFrom() != null) {
		sql.append(" AND o.created_at >= ?");
		params.add(Timestamp.valueOf(query.getCreateFrom()));
	    }

	    if (query.getCreateTo() != null) {
		sql.append(" AND o.created_at <= ?");
		params.add(Timestamp.valueOf(query.getCreateTo()));
	    }

	    sql.append(" ORDER BY order_id ASC");
	}

	try (Connection conn = dataSource.getConnection();
		PreparedStatement prepare = conn.prepareStatement(sql.toString())) {
	    ;

	    for (int i = 0; i < params.size(); i++) {
		prepare.setObject(i + 1, params.get(i));
	    }

	    ResultSet rs = prepare.executeQuery();
	    while (rs.next()) {
		var order = new OrderResponseDTO();
		order.setOrderId(rs.getLong("order_id"));
		order.setCustomerName(rs.getString("customer_name"));
		order.setOrderStatus(Status.valueOf(rs.getString("order_status")));
		order.setShipmentStatus(Status.valueOf(rs.getString("shipment_status")));
		order.setTotal(rs.getBigDecimal("total"));
		order.setCreateAt(rs.getTimestamp("created_at").toLocalDateTime());
		orders.add(order);
	    }

	    return orders;
	}
    }

    @Override
    public Orders getOne(long id) throws SQLException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public OrderResponseDTO create(OrderRequestDTO o) throws SQLException {
	String sqlShipment = "INSERT INTO shipment (method , status, amount, paid_at) VALUES (? , ?, ?, ?)";
	String sqlOrder = "INSERT INTO orders (customer_id, shipment_id, total, status, payment_status) VALUES (? , ? ,? ,? ,?)";
	String sqlOrderItems = "INSERT INTO order_item (order_id, product_id, quantity, price) VALUES (? ,? ,? ,?)";
	String sqlSelect = """
		SELECT o.id as order_id, c.name as customer_name, o.status as order_status,
		s.status as shipment_status, o.total, o.created_at
		FROM orders o
		JOIN customer c ON o.customer_id = c.id
		Join shipment s ON o.shipment_id = s.id
		WHERE o.id = ?
		""";
	int shipmentId;
	int orderId;
	OrderResponseDTO res = new OrderResponseDTO();
	try (Connection conn = dataSource.getConnection()) {
	    conn.setAutoCommit(false);

	    try (PreparedStatement prepareShipment = conn.prepareStatement(sqlShipment,
		    Statement.RETURN_GENERATED_KEYS);) {
		prepareShipment.setString(1, o.getShipmentMethod());
		prepareShipment.setString(2, "PENDING");
		prepareShipment.setBigDecimal(3, o.getTotal());
		prepareShipment.setDate(4, new Date(System.currentTimeMillis()));

		prepareShipment.executeUpdate();

		try (ResultSet generatedKeys = prepareShipment.getGeneratedKeys()) {
		    if (generatedKeys.next()) {
			shipmentId = generatedKeys.getInt(1);
		    } else {
			conn.rollback();
			throw new SQLException("Failed to insert shipment");
		    }
		}
	    }

	    try (PreparedStatement prepareOrder = conn.prepareStatement(sqlOrder, Statement.RETURN_GENERATED_KEYS)) {
		prepareOrder.setLong(1, o.getCustomerId());
		prepareOrder.setInt(2, shipmentId);
		prepareOrder.setBigDecimal(3, o.getTotal());
		prepareOrder.setString(4, "PENDING");
		prepareOrder.setString(5, "PENDING");

		prepareOrder.executeUpdate();

		try (ResultSet generatedKeys = prepareOrder.getGeneratedKeys()) {
		    if (generatedKeys.next()) {
			orderId = generatedKeys.getInt(1);
		    } else {
			conn.rollback();
			throw new SQLException("Failed to insert order.");
		    }
		}
	    }

	    try (PreparedStatement prepareOrderItem = conn.prepareStatement(sqlOrderItems)) {
		for (OrderItemDTO item : o.getItems()) {
		    prepareOrderItem.setInt(1, orderId);
		    prepareOrderItem.setLong(2, item.getProductId());
		    prepareOrderItem.setInt(3, item.getQuantity());
		    prepareOrderItem.setBigDecimal(4, item.getPrice());
		    prepareOrderItem.addBatch();
		}
		prepareOrderItem.executeBatch();
	    }
	    conn.commit();

	    try (PreparedStatement prepareSelect = conn.prepareStatement(sqlSelect)) {
		prepareSelect.setInt(1, orderId);
		ResultSet rs = prepareSelect.executeQuery();

		if (rs.next()) {

		    res.setOrderId(rs.getLong("order_id"));
		    res.setCustomerName(rs.getString("customer_name"));
		    res.setOrderStatus(Status.valueOf(rs.getString("order_status")));
		    res.setShipmentStatus(Status.valueOf(rs.getString("shipment_status")));
		    res.setTotal(rs.getBigDecimal("total"));
		    Timestamp ts = rs.getTimestamp("created_at");
		    res.setCreateAt(ts != null ? ts.toLocalDateTime() : null);

		} else {
		    throw new SQLException("Cannot fetch create order");
		}
	    }
	    return res;
	} catch (Exception ex) {
	    ex.printStackTrace();
	    throw new SQLException(ex);
	}
    }

    @Override
    public Orders update(Orders o) throws SQLException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public void delete(long id) throws SQLException {
	// TODO Auto-generated method stub

    }

    @Override
    public Orders create(Orders t) throws SQLException {
	// TODO Auto-generated method stub
	return null;
    }

}
