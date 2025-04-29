import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'status'
})
export class StatusTagsPipe implements PipeTransform {
  private StatusColors: { [ key:string]:string} = {
    PENDING: 'yellow',
    SUCCESS: 'green',
    FAILED: 'red'
  }

  transform(status:string): string {
    return this.StatusColors[status.toUpperCase()] || 'gray';
  }

}
