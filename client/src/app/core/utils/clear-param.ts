export const clearParam =(param:{ [key:string] :any}):{ [key:string] :any} =>{
 return Object.fromEntries(Object.entries(param).filter(([_,v])=> v != null && v !== ''))
}
