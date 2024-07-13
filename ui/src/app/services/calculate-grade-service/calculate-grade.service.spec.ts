import { TestBed } from '@angular/core/testing';

import { CalculateGradeService } from './calculate-grade.service';

describe('CalculateGradeService', () => {
  let service: CalculateGradeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CalculateGradeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
