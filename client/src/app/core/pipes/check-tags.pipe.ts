import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'check'
})
export class CheckTagsPipe implements PipeTransform {
  transform(value:boolean): { text: string; color: 'primary' | 'warn' } {
    return value
      ? { text: 'Deleted', color: 'warn' }
      : { text: 'Active', color: 'primary' };
  }

}
