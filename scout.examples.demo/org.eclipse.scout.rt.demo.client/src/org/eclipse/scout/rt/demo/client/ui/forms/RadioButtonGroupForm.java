package org.eclipse.scout.rt.demo.client.ui.forms;

import org.eclipse.scout.commons.annotations.Order;
import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.rt.client.ui.form.AbstractForm;
import org.eclipse.scout.rt.client.ui.form.AbstractFormHandler;
import org.eclipse.scout.rt.client.ui.form.fields.button.AbstractCloseButton;
import org.eclipse.scout.rt.client.ui.form.fields.button.AbstractRadioButton;
import org.eclipse.scout.rt.client.ui.form.fields.groupbox.AbstractGroupBox;
import org.eclipse.scout.rt.client.ui.form.fields.listbox.AbstractListBox;
import org.eclipse.scout.rt.client.ui.form.fields.radiobuttongroup.AbstractRadioButtonGroup;
import org.eclipse.scout.rt.client.ui.form.fields.smartfield.AbstractSmartField;
import org.eclipse.scout.rt.client.ui.form.fields.stringfield.AbstractStringField;
import org.eclipse.scout.rt.demo.client.services.lookup.DateLookupCall;
import org.eclipse.scout.rt.demo.client.ui.forms.RadioButtonGroupForm.MainBox.CloseButton;
import org.eclipse.scout.rt.demo.client.ui.forms.RadioButtonGroupForm.MainBox.GroupBox;
import org.eclipse.scout.rt.demo.client.ui.forms.RadioButtonGroupForm.MainBox.GroupBox.RadioButtonGroup;
import org.eclipse.scout.rt.demo.client.ui.forms.RadioButtonGroupForm.MainBox.GroupBox.RadioButtonGroup.DateField;
import org.eclipse.scout.rt.demo.client.ui.forms.RadioButtonGroupForm.MainBox.GroupBox.RadioButtonGroup.ExistingDateButton;
import org.eclipse.scout.rt.demo.client.ui.forms.RadioButtonGroupForm.MainBox.GroupBox.RadioButtonGroup.MonthField;
import org.eclipse.scout.rt.demo.client.ui.forms.RadioButtonGroupForm.MainBox.GroupBox.RadioButtonGroup.NewDateButton;
import org.eclipse.scout.rt.demo.client.ui.forms.RadioButtonGroupForm.MainBox.GroupBox.RadioButtonGroup.YearField;
import org.eclipse.scout.rt.shared.TEXTS;
import org.eclipse.scout.rt.shared.services.lookup.LookupCall;

public class RadioButtonGroupForm extends AbstractForm implements IPageForm {

  public RadioButtonGroupForm() throws ProcessingException {
    super();
  }

  @Override
  protected String getConfiguredTitle() {
    return TEXTS.get("RadioButtonGroup");
  }

  public void startModify() throws ProcessingException {
    startInternal(new ModifyHandler());
  }

  public void startNew() throws ProcessingException {
    startInternal(new NewHandler());
  }

  @Override
  public void startPageForm() throws ProcessingException {
    startInternal(new PageFormHandler());
  }

  @Override
  public CloseButton getCloseButton() {
    return getFieldByClass(CloseButton.class);
  }

  public DateField getDateField() {
    return getFieldByClass(DateField.class);
  }

  public ExistingDateButton getExistingDateButton() {
    return getFieldByClass(ExistingDateButton.class);
  }

  public GroupBox getGroupBox() {
    return getFieldByClass(GroupBox.class);
  }

  public MainBox getMainBox() {
    return getFieldByClass(MainBox.class);
  }

  public MonthField getMonthField() {
    return getFieldByClass(MonthField.class);
  }

  public NewDateButton getNewDateButton() {
    return getFieldByClass(NewDateButton.class);
  }

  public RadioButtonGroup getRadioButtonGroup() {
    return getFieldByClass(RadioButtonGroup.class);
  }

  public YearField getYearField() {
    return getFieldByClass(YearField.class);
  }

  @Order(10.0)
  public class MainBox extends AbstractGroupBox {

    @Order(10.0)
    public class GroupBox extends AbstractGroupBox {

      @Order(10.0)
      public class RadioButtonGroup extends AbstractRadioButtonGroup<Long> {

        @Override
        protected int getConfiguredGridH() {
          return 2;
        }

        @Override
        protected boolean getConfiguredLabelVisible() {
          return false;
        }

        @Order(10.0)
        public class NewDateButton extends AbstractRadioButton {

          @Override
          protected String getConfiguredLabel() {
            return TEXTS.get("NewDate");
          }

          @Override
          protected void execClickAction() throws ProcessingException {
            getMonthField().setEnabled(getNewDateButton().isSelected());
            getYearField().setEnabled(getNewDateButton().isSelected());
            getDateField().setEnabled(getExistingDateButton().isSelected());
          }
        }

        @Order(20.0)
        public class MonthField extends AbstractStringField {

          @Override
          protected String getConfiguredLabel() {
            return TEXTS.get("Month");
          }
        }

        @Order(30.0)
        public class YearField extends AbstractListBox<Long> {

          @Override
          protected String getConfiguredLabel() {
            return TEXTS.get("Year");
          }
        }

        @Order(50.0)
        public class ExistingDateButton extends AbstractRadioButton {

          @Override
          protected String getConfiguredLabel() {
            return TEXTS.get("ExistingDate");
          }

          @Override
          protected void execClickAction() throws ProcessingException {
            getMonthField().setEnabled(getNewDateButton().isSelected());
            getYearField().setEnabled(getNewDateButton().isSelected());
            getDateField().setEnabled(getExistingDateButton().isSelected());
          }
        }

        @Order(60.0)
        public class DateField extends AbstractSmartField<Long> {

          @Override
          protected boolean getConfiguredEnabled() {
            return false;
          }

          @Override
          protected String getConfiguredLabel() {
            return TEXTS.get("Date");
          }

          @Override
          protected Class<? extends LookupCall> getConfiguredLookupCall() {
            return DateLookupCall.class;
          }
        }
      }
    }

    @Order(30.0)
    public class CloseButton extends AbstractCloseButton {
    }
  }

  public class ModifyHandler extends AbstractFormHandler {
  }

  public class NewHandler extends AbstractFormHandler {
  }

  public class PageFormHandler extends AbstractFormHandler {
  }
}