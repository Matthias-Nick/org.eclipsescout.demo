/*******************************************************************************
 * Copyright (c) 2013 BSI Business Systems Integration AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     BSI Business Systems Integration AG - initial API and implementation
 ******************************************************************************/
package org.eclipsescout.demo.widgets.client.ui.forms;

import org.eclipse.scout.commons.annotations.Order;
import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.rt.client.ui.form.AbstractForm;
import org.eclipse.scout.rt.client.ui.form.AbstractFormHandler;
import org.eclipse.scout.rt.client.ui.form.fields.IFormField;
import org.eclipse.scout.rt.client.ui.form.fields.IValueField;
import org.eclipse.scout.rt.client.ui.form.fields.bigdecimalfield.AbstractBigDecimalField;
import org.eclipse.scout.rt.client.ui.form.fields.bigintegerfield.AbstractBigIntegerField;
import org.eclipse.scout.rt.client.ui.form.fields.button.AbstractButton;
import org.eclipse.scout.rt.client.ui.form.fields.button.AbstractCloseButton;
import org.eclipse.scout.rt.client.ui.form.fields.datefield.AbstractDateField;
import org.eclipse.scout.rt.client.ui.form.fields.datefield.AbstractDateTimeField;
import org.eclipse.scout.rt.client.ui.form.fields.datefield.AbstractTimeField;
import org.eclipse.scout.rt.client.ui.form.fields.doublefield.AbstractDoubleField;
import org.eclipse.scout.rt.client.ui.form.fields.filechooserfield.AbstractFileChooserField;
import org.eclipse.scout.rt.client.ui.form.fields.groupbox.AbstractGroupBox;
import org.eclipse.scout.rt.client.ui.form.fields.imagebox.AbstractImageField;
import org.eclipse.scout.rt.client.ui.form.fields.integerfield.AbstractIntegerField;
import org.eclipse.scout.rt.client.ui.form.fields.labelfield.AbstractLabelField;
import org.eclipse.scout.rt.client.ui.form.fields.longfield.AbstractLongField;
import org.eclipse.scout.rt.client.ui.form.fields.sequencebox.AbstractSequenceBox;
import org.eclipse.scout.rt.client.ui.form.fields.smartfield.AbstractSmartField;
import org.eclipse.scout.rt.client.ui.form.fields.stringfield.AbstractStringField;
import org.eclipse.scout.rt.shared.TEXTS;
import org.eclipse.scout.rt.shared.services.lookup.LookupCall;
import org.eclipsescout.demo.widgets.client.services.lookup.DateLookupCall;
import org.eclipsescout.demo.widgets.client.ui.forms.OverviewForm.MainBox.AllEnabledButton;
import org.eclipsescout.demo.widgets.client.ui.forms.OverviewForm.MainBox.AllMandatoryButton;
import org.eclipsescout.demo.widgets.client.ui.forms.OverviewForm.MainBox.ButtonsBox;
import org.eclipsescout.demo.widgets.client.ui.forms.OverviewForm.MainBox.ButtonsBox.DefaultButton;
import org.eclipsescout.demo.widgets.client.ui.forms.OverviewForm.MainBox.ButtonsBox.LinkButton;
import org.eclipsescout.demo.widgets.client.ui.forms.OverviewForm.MainBox.ButtonsBox.RadioButton;
import org.eclipsescout.demo.widgets.client.ui.forms.OverviewForm.MainBox.ButtonsBox.ToggleButton;
import org.eclipsescout.demo.widgets.client.ui.forms.OverviewForm.MainBox.ButtonsVisibleButton;
import org.eclipsescout.demo.widgets.client.ui.forms.OverviewForm.MainBox.CloseButton;
import org.eclipsescout.demo.widgets.client.ui.forms.OverviewForm.MainBox.MaximizeButton;
import org.eclipsescout.demo.widgets.client.ui.forms.OverviewForm.MainBox.MinimizeButton;
import org.eclipsescout.demo.widgets.client.ui.forms.OverviewForm.MainBox.OpenModalFormButton;
import org.eclipsescout.demo.widgets.client.ui.forms.OverviewForm.MainBox.OpenNonModalFormButton;
import org.eclipsescout.demo.widgets.client.ui.forms.OverviewForm.MainBox.SequenceBoxesBox;
import org.eclipsescout.demo.widgets.client.ui.forms.OverviewForm.MainBox.SequenceBoxesBox.Birthday2Box;
import org.eclipsescout.demo.widgets.client.ui.forms.OverviewForm.MainBox.SequenceBoxesBox.Birthday2Box.Birthday2From;
import org.eclipsescout.demo.widgets.client.ui.forms.OverviewForm.MainBox.SequenceBoxesBox.Birthday2Box.Birthday2To;
import org.eclipsescout.demo.widgets.client.ui.forms.OverviewForm.MainBox.SequenceBoxesBox.BirthdayBox;
import org.eclipsescout.demo.widgets.client.ui.forms.OverviewForm.MainBox.SequenceBoxesBox.BirthdayBox.BirthdayFrom;
import org.eclipsescout.demo.widgets.client.ui.forms.OverviewForm.MainBox.SequenceBoxesBox.BirthdayBox.BirthdayTo;
import org.eclipsescout.demo.widgets.client.ui.forms.OverviewForm.MainBox.SimpleFieldsBox;
import org.eclipsescout.demo.widgets.client.ui.forms.OverviewForm.MainBox.SimpleFieldsBox.BigDecimalField;
import org.eclipsescout.demo.widgets.client.ui.forms.OverviewForm.MainBox.SimpleFieldsBox.BigIntegerField;
import org.eclipsescout.demo.widgets.client.ui.forms.OverviewForm.MainBox.SimpleFieldsBox.DateField;
import org.eclipsescout.demo.widgets.client.ui.forms.OverviewForm.MainBox.SimpleFieldsBox.DateTimeField;
import org.eclipsescout.demo.widgets.client.ui.forms.OverviewForm.MainBox.SimpleFieldsBox.DoubleField;
import org.eclipsescout.demo.widgets.client.ui.forms.OverviewForm.MainBox.SimpleFieldsBox.FileChooserField;
import org.eclipsescout.demo.widgets.client.ui.forms.OverviewForm.MainBox.SimpleFieldsBox.ImageField;
import org.eclipsescout.demo.widgets.client.ui.forms.OverviewForm.MainBox.SimpleFieldsBox.IntegerField;
import org.eclipsescout.demo.widgets.client.ui.forms.OverviewForm.MainBox.SimpleFieldsBox.LabelField;
import org.eclipsescout.demo.widgets.client.ui.forms.OverviewForm.MainBox.SimpleFieldsBox.LongField;
import org.eclipsescout.demo.widgets.client.ui.forms.OverviewForm.MainBox.SimpleFieldsBox.SmartField;
import org.eclipsescout.demo.widgets.client.ui.forms.OverviewForm.MainBox.SimpleFieldsBox.StringField;
import org.eclipsescout.demo.widgets.client.ui.forms.OverviewForm.MainBox.SimpleFieldsBox.StringFieldForPasswordField;
import org.eclipsescout.demo.widgets.client.ui.forms.OverviewForm.MainBox.SimpleFieldsBox.TimeField;
import org.eclipsescout.demo.widgets.client.ui.forms.OverviewForm.MainBox.StartProcessButton;

public class OverviewForm extends AbstractForm implements IPageForm {

  public OverviewForm() throws ProcessingException {
    super();
  }

  @Override
  protected boolean getConfiguredAskIfNeedSave() {
    return false;
  }

  @Override
  protected boolean getConfiguredMaximizeEnabled() {
    return true;
  }

  @Override
  protected boolean getConfiguredMinimizeEnabled() {
    return true;
  }

  @Override
  protected String getConfiguredTitle() {
    return TEXTS.get("Overview");
  }

  @Override
  public void startPageForm() throws ProcessingException {
    startInternal(new PageFormHandler());
  }

  public AllEnabledButton getAllEnabledButton() {
    return getFieldByClass(AllEnabledButton.class);
  }

  public AllMandatoryButton getAllMandatoryButton() {
    return getFieldByClass(AllMandatoryButton.class);
  }

  public BigDecimalField getBigDecimalField() {
    return getFieldByClass(BigDecimalField.class);
  }

  public BigIntegerField getBigIntegerField() {
    return getFieldByClass(BigIntegerField.class);
  }

  public Birthday2Box getBirthday2Box() {
    return getFieldByClass(Birthday2Box.class);
  }

  public Birthday2From getBirthday2From() {
    return getFieldByClass(Birthday2From.class);
  }

  public Birthday2To getBirthday2To() {
    return getFieldByClass(Birthday2To.class);
  }

  public BirthdayBox getBirthdayBox() {
    return getFieldByClass(BirthdayBox.class);
  }

  public BirthdayFrom getBirthdayFrom() {
    return getFieldByClass(BirthdayFrom.class);
  }

  public BirthdayTo getBirthdayTo() {
    return getFieldByClass(BirthdayTo.class);
  }

  public ButtonsBox getButtonsBox() {
    return getFieldByClass(ButtonsBox.class);
  }

  public ButtonsVisibleButton getButtonsVisibleButton() {
    return getFieldByClass(ButtonsVisibleButton.class);
  }

  @Override
  public CloseButton getCloseButton() {
    return getFieldByClass(CloseButton.class);
  }

  public DateField getDateField() {
    return getFieldByClass(DateField.class);
  }

  public DateTimeField getDateTimeField() {
    return getFieldByClass(DateTimeField.class);
  }

  public DefaultButton getDefaultButton() {
    return getFieldByClass(DefaultButton.class);
  }

  public DoubleField getDoubleField() {
    return getFieldByClass(DoubleField.class);
  }

  public FileChooserField getFileChooserField() {
    return getFieldByClass(FileChooserField.class);
  }

  public ImageField getImageField() {
    return getFieldByClass(ImageField.class);
  }

  public IntegerField getIntegerField() {
    return getFieldByClass(IntegerField.class);
  }

  public LabelField getLabelField() {
    return getFieldByClass(LabelField.class);
  }

  public LinkButton getLinkButton() {
    return getFieldByClass(LinkButton.class);
  }

  public LongField getLongField() {
    return getFieldByClass(LongField.class);
  }

  public MainBox getMainBox() {
    return getFieldByClass(MainBox.class);
  }

  public MaximizeButton getMaximizeButton() {
    return getFieldByClass(MaximizeButton.class);
  }

  public MinimizeButton getMinimizeButton() {
    return getFieldByClass(MinimizeButton.class);
  }

  public OpenModalFormButton getOpenModalFormButton() {
    return getFieldByClass(OpenModalFormButton.class);
  }

  public OpenNonModalFormButton getOpenNonModalFormButton() {
    return getFieldByClass(OpenNonModalFormButton.class);
  }

  public RadioButton getRadioButton() {
    return getFieldByClass(RadioButton.class);
  }

  public SequenceBoxesBox getSequenceBoxesBox() {
    return getFieldByClass(SequenceBoxesBox.class);
  }

  public SimpleFieldsBox getSimpleFieldsBox() {
    return getFieldByClass(SimpleFieldsBox.class);
  }

  public SmartField getSmartField() {
    return getFieldByClass(SmartField.class);
  }

  public StartProcessButton getStartProcessButton() {
    return getFieldByClass(StartProcessButton.class);
  }

  public StringField getStringField() {
    return getFieldByClass(StringField.class);
  }

  public StringFieldForPasswordField getStringFieldForPasswordField() {
    return getFieldByClass(StringFieldForPasswordField.class);
  }

  public TimeField getTimeField() {
    return getFieldByClass(TimeField.class);
  }

  public ToggleButton getToggleButton() {
    return getFieldByClass(ToggleButton.class);
  }

  @Order(10.0)
  public class MainBox extends AbstractGroupBox {

    @Override
    protected boolean getConfiguredGridUseUiWidth() {
      return true;
    }

    @Override
    protected boolean getConfiguredScrollable() {
      return true;
    }

    @Order(10.0)
    public class ButtonsBox extends AbstractGroupBox {

      @Override
      protected String getConfiguredBorderDecoration() {
        return BORDER_DECORATION_SECTION;
      }

      @Override
      protected boolean getConfiguredExpandable() {
        return true;
      }

      @Override
      protected String getConfiguredLabel() {
        return TEXTS.get("Buttons");
      }

      @Order(10.0)
      public class DefaultButton extends AbstractButton {

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("DefaultButton");
        }

        @Override
        protected boolean getConfiguredProcessButton() {
          return false;
        }
      }

      @Order(20.0)
      public class LinkButton extends AbstractButton {

        @Override
        protected int getConfiguredDisplayStyle() {
          return DISPLAY_STYLE_LINK;
        }

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("LinkButton");
        }

        @Override
        protected boolean getConfiguredProcessButton() {
          return false;
        }
      }

      @Order(30.0)
      public class RadioButton extends AbstractButton {

        @Override
        protected int getConfiguredDisplayStyle() {
          return DISPLAY_STYLE_RADIO;
        }

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("RadioButton");
        }

        @Override
        protected boolean getConfiguredProcessButton() {
          return false;
        }
      }

      @Order(40.0)
      public class ToggleButton extends AbstractButton {

        @Override
        protected int getConfiguredDisplayStyle() {
          return DISPLAY_STYLE_TOGGLE;
        }

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("ToggleButton");
        }

        @Override
        protected boolean getConfiguredProcessButton() {
          return false;
        }
      }
    }

    @Order(20.0)
    public class SimpleFieldsBox extends AbstractGroupBox {

      @Override
      protected String getConfiguredLabel() {
        return TEXTS.get("SimpleFields");
      }

      @Order(10.0)
      public class DateField extends AbstractDateField {

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("DateField");
        }
      }

      @Order(20.0)
      public class BigDecimalField extends AbstractBigDecimalField {

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("BigDecimalField");
        }
      }

      @Order(30.0)
      public class BigIntegerField extends AbstractBigIntegerField {

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("BigIntegerField");
        }
      }

      @Order(40.0)
      public class DoubleField extends AbstractDoubleField {

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("DoubleField");
        }
      }

      @Order(50.0)
      public class FileChooserField extends AbstractFileChooserField {

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("FileChooserField");
        }

        @Override
        protected boolean getConfiguredTypeLoad() {
          return true;
        }
      }

      @Order(60.0)
      public class ImageField extends AbstractImageField {

        @Override
        protected int getConfiguredGridH() {
          return 6;
        }

        @Override
        protected int getConfiguredGridW() {
          return 2;
        }

        @Override
        protected String getConfiguredImageId() {
          return "scout_logo.jpg";
        }

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("ImageField");
        }
      }

      @Order(70.0)
      public class LabelField extends AbstractLabelField {

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("LabelField");
        }

        @Override
        protected void execInitField() throws ProcessingException {
          setValue(TEXTS.get("Lorem"));
        }
      }

      @Order(80.0)
      public class IntegerField extends AbstractIntegerField {

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("IntegerField");
        }
      }

      @Order(90.0)
      public class SmartField extends AbstractSmartField<Long> {

        @Override
        protected boolean getConfiguredBrowseHierarchy() {
          return true;
        }

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("SmartField");
        }

        @Override
        protected Class<? extends LookupCall> getConfiguredLookupCall() {
          return DateLookupCall.class;
        }
      }

      @Order(100.0)
      public class StringField extends AbstractStringField {

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("StringField");
        }
      }

      @Order(110.0)
      public class TimeField extends AbstractTimeField {

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("TimeField");
        }
      }

      @Order(120.0)
      public class DateTimeField extends AbstractDateTimeField {

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("DateTimeField");
        }
      }

      @Order(130.0)
      public class StringFieldForPasswordField extends AbstractStringField {

        @Override
        protected boolean getConfiguredInputMasked() {
          return true;
        }

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("StringFieldForPassword");
        }
      }

      @Order(140.0)
      public class LongField extends AbstractLongField {

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("LongField");
        }
      }
    }

    @Order(30.0)
    public class SequenceBoxesBox extends AbstractGroupBox {

      @Override
      protected String getConfiguredLabel() {
        return TEXTS.get("SequenceBoxes");
      }

      @Order(10.0)
      public class BirthdayBox extends AbstractSequenceBox {

        @Override
        protected int getConfiguredGridW() {
          return 2;
        }

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("Birthday");
        }

        @Order(10.0)
        public class BirthdayFrom extends AbstractDateField {

          @Override
          protected String getConfiguredLabel() {
            return TEXTS.get("from");
          }
        }

        @Order(20.0)
        public class BirthdayTo extends AbstractDateField {

          @Override
          protected String getConfiguredLabel() {
            return TEXTS.get("to");
          }
        }
      }

      @Order(20.0)
      public class Birthday2Box extends AbstractSequenceBox {

        @Override
        protected int getConfiguredGridW() {
          return 2;
        }

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("Birthday");
        }

        @Order(10.0)
        public class Birthday2From extends AbstractDateField {

          @Override
          protected String getConfiguredLabel() {
            return TEXTS.get("from");
          }

          @Override
          protected int getConfiguredLabelPosition() {
            return LABEL_POSITION_ON_FIELD;
          }
        }

        @Order(20.0)
        public class Birthday2To extends AbstractDateField {

          @Override
          protected String getConfiguredLabel() {
            return TEXTS.get("to");
          }

          @Override
          protected int getConfiguredLabelPosition() {
            return LABEL_POSITION_ON_FIELD;
          }
        }
      }
    }

    @Order(40.0)
    public class CloseButton extends AbstractCloseButton {
    }

    @Order(50.0)
    public class ButtonsVisibleButton extends AbstractButton {

      @Override
      protected int getConfiguredDisplayStyle() {
        return DISPLAY_STYLE_TOGGLE;
      }

      @Override
      protected String getConfiguredLabel() {
        return TEXTS.get("ButtonsVisible");
      }

      @Override
      protected void execClickAction() throws ProcessingException {
        getButtonsBox().setVisible(isSelected());
      }

      @Override
      protected void execInitField() throws ProcessingException {
        setSelected(true);
      }
    }

    @Order(60.0)
    public class StartProcessButton extends AbstractButton {

      @Override
      protected String getConfiguredLabel() {
        return TEXTS.get("StartProcess");
      }

      @Override
      protected void execClickAction() throws ProcessingException {
        try {
          Thread.sleep(5000);
        }
        catch (InterruptedException e) {
          throw new ProcessingException("Process stopped ", e);
        }
      }
    }

    @Order(70.0)
    public class AllMandatoryButton extends AbstractButton {

      @Override
      protected int getConfiguredDisplayStyle() {
        return DISPLAY_STYLE_TOGGLE;
      }

      @Override
      protected String getConfiguredLabel() {
        return TEXTS.get("AllMandatory");
      }

      @Override
      protected void execClickAction() throws ProcessingException {
        for (IFormField f : getAllFields()) {
          if (f instanceof IValueField<?>) {
            ((IValueField<?>) f).setMandatory(isSelected());
          }
        }
      }
    }

    @Order(80.0)
    public class AllEnabledButton extends AbstractButton {

      @Override
      protected int getConfiguredDisplayStyle() {
        return DISPLAY_STYLE_TOGGLE;
      }

      @Override
      protected String getConfiguredLabel() {
        return TEXTS.get("AllEnabled");
      }

      @Override
      protected void execClickAction() throws ProcessingException {
        for (IFormField f : getAllFields()) {
          if (f instanceof IValueField<?>) {
            ((IValueField<?>) f).setEnabled(isSelected());
          }
        }
      }

      @Override
      protected void execInitField() throws ProcessingException {
        setSelected(true);
      }
    }

    @Order(90.0)
    public class MinimizeButton extends AbstractButton {

      @Override
      protected String getConfiguredLabel() {
        return TEXTS.get("Minimize");
      }

      @Override
      protected void execClickAction() throws ProcessingException {
        setMinimized(true);
      }
    }

    @Order(100.0)
    public class MaximizeButton extends AbstractButton {

      @Override
      protected String getConfiguredLabel() {
        return TEXTS.get("Maximize");
      }

      @Override
      protected void execClickAction() throws ProcessingException {
        setMaximized(true);
      }
    }

    @Order(110.0)
    public class OpenNonModalFormButton extends AbstractButton {

      @Override
      protected String getConfiguredLabel() {
        return TEXTS.get("OpenNonModalForm");
      }

      @Override
      protected void execClickAction() throws ProcessingException {
        OverviewForm form = new OverviewForm();
        form.setModal(false);
        form.startPageForm();
      }
    }

    @Order(120.0)
    public class OpenModalFormButton extends AbstractButton {

      @Override
      protected String getConfiguredLabel() {
        return TEXTS.get("OpenModalForm");
      }

      @Override
      protected void execClickAction() throws ProcessingException {
        OverviewForm form = new OverviewForm();
        form.setModal(true);
        form.getOpenNonModalFormButton().setVisible(false);
        form.startPageForm();
      }
    }
  }

  public class PageFormHandler extends AbstractFormHandler {
  }
}
