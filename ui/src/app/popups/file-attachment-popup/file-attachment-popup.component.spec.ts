import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FileAttachmentPopupComponent } from './file-attachment-popup.component';

describe('FileAttachmentPopupComponent', () => {
  let component: FileAttachmentPopupComponent;
  let fixture: ComponentFixture<FileAttachmentPopupComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FileAttachmentPopupComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FileAttachmentPopupComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
