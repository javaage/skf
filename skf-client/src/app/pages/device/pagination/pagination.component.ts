import { Component, EventEmitter, OnInit, Input, Output } from '@angular/core';

@Component({
  selector: 'pagination',
  templateUrl: 'pagination.component.html',
  styleUrls: ['pagination.component.scss']
})
export class PaginationComponent implements OnInit {
  @Input() totalPage: number;
  @Input() currentPage: number;
  @Output() pageChange = new EventEmitter<number>();

  constructor() { }

  ngOnInit() {
  }

  changePage(pageNum) {
    this.pageChange.emit(pageNum);
  }

  goPrevious(pageNum) {
    if (pageNum >= 1) {
      this.changePage(pageNum - 1);
    }
  }

  goNext(pageNum) {
    if (pageNum <= this.totalPage - 2) {
      this.changePage(pageNum + 1);
    }
  }
}
