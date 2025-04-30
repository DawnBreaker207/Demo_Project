import { DatePipe } from "@angular/common"

export const formatDateUtils = (date: Date |string):string | null=>{
  const datePipe = new DatePipe('en-US');
  return datePipe.transform(date, 'yyyy-MM-ddTHH:mm:ss');
}
