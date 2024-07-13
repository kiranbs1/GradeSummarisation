import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FileAttachmentPanelComponent } from './file-attachment-panel.component';

describe('FileAttachmentPanelComponent', () => {
  let component: FileAttachmentPanelComponent;
  let fixture: ComponentFixture<FileAttachmentPanelComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FileAttachmentPanelComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FileAttachmentPanelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
