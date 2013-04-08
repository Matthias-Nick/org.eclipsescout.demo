package org.eclipse.scout.ibug.shared.services;

import org.eclipse.scout.rt.shared.data.form.AbstractFormData;
import org.eclipse.scout.rt.shared.data.form.ValidationRule;
import org.eclipse.scout.rt.shared.data.form.fields.AbstractValueFieldData;
import org.eclipse.scout.rt.shared.data.form.fields.tablefield.AbstractTableFieldData;

public class DesktopFormData extends AbstractFormData {
  private static final long serialVersionUID = 1L;

  public DesktopFormData() {
  }

  public Assignee getAssignee() {
    return getFieldByClass(Assignee.class);
  }

  public Bugs getBugs() {
    return getFieldByClass(Bugs.class);
  }

  public Product getProduct() {
    return getFieldByClass(Product.class);
  }

  public static class Assignee extends AbstractValueFieldData<String> {
    private static final long serialVersionUID = 1L;

    public Assignee() {
    }

    /**
     * list of derived validation rules.
     */
    @Override
    protected void initValidationRules(java.util.Map<String, Object> ruleMap) {
      super.initValidationRules(ruleMap);
      ruleMap.put(ValidationRule.MAX_LENGTH, 4000);
    }
  }

  public static class Bugs extends AbstractTableFieldData {
    private static final long serialVersionUID = 1L;

    public Bugs() {
    }

    public static final int ID_COLUMN_ID = 0;
    public static final int SUMMARY_COLUMN_ID = 1;
    public static final int LAST_CHANGED_COLUMN_ID = 2;
    public static final int SEVERETY_COLUMN_ID = 3;
    public static final int PRIORITY_COLUMN_ID = 4;
    public static final int TARGET_MILESTONE_COLUMN_ID = 5;
    public static final int STATUS_COLUMN_ID = 6;
    public static final int RESOLUTION_COLUMN_ID = 7;
    public static final int COMPONENT_COLUMN_ID = 8;
    public static final int ASSIGNEE_COLUMN_ID = 9;
    public static final int SORT_VALUE_COLUMN_ID = 10;

    public void setID(int row, String iD) {
      setValueInternal(row, ID_COLUMN_ID, iD);
    }

    public String getID(int row) {
      return (String) getValueInternal(row, ID_COLUMN_ID);
    }

    public void setSummary(int row, String summary) {
      setValueInternal(row, SUMMARY_COLUMN_ID, summary);
    }

    public String getSummary(int row) {
      return (String) getValueInternal(row, SUMMARY_COLUMN_ID);
    }

    public void setLastChanged(int row, String lastChanged) {
      setValueInternal(row, LAST_CHANGED_COLUMN_ID, lastChanged);
    }

    public String getLastChanged(int row) {
      return (String) getValueInternal(row, LAST_CHANGED_COLUMN_ID);
    }

    public void setSeverety(int row, String severety) {
      setValueInternal(row, SEVERETY_COLUMN_ID, severety);
    }

    public String getSeverety(int row) {
      return (String) getValueInternal(row, SEVERETY_COLUMN_ID);
    }

    public void setPriority(int row, String priority) {
      setValueInternal(row, PRIORITY_COLUMN_ID, priority);
    }

    public String getPriority(int row) {
      return (String) getValueInternal(row, PRIORITY_COLUMN_ID);
    }

    public void setTargetMilestone(int row, String targetMilestone) {
      setValueInternal(row, TARGET_MILESTONE_COLUMN_ID, targetMilestone);
    }

    public String getTargetMilestone(int row) {
      return (String) getValueInternal(row, TARGET_MILESTONE_COLUMN_ID);
    }

    public void setStatus(int row, String status) {
      setValueInternal(row, STATUS_COLUMN_ID, status);
    }

    public String getStatus(int row) {
      return (String) getValueInternal(row, STATUS_COLUMN_ID);
    }

    public void setResolution(int row, String resolution) {
      setValueInternal(row, RESOLUTION_COLUMN_ID, resolution);
    }

    public String getResolution(int row) {
      return (String) getValueInternal(row, RESOLUTION_COLUMN_ID);
    }

    public void setComponent(int row, String component) {
      setValueInternal(row, COMPONENT_COLUMN_ID, component);
    }

    public String getComponent(int row) {
      return (String) getValueInternal(row, COMPONENT_COLUMN_ID);
    }

    public void setAssignee(int row, String assignee) {
      setValueInternal(row, ASSIGNEE_COLUMN_ID, assignee);
    }

    public String getAssignee(int row) {
      return (String) getValueInternal(row, ASSIGNEE_COLUMN_ID);
    }

    public void setSortValue(int row, Integer sortValue) {
      setValueInternal(row, SORT_VALUE_COLUMN_ID, sortValue);
    }

    public Integer getSortValue(int row) {
      return (Integer) getValueInternal(row, SORT_VALUE_COLUMN_ID);
    }

    @Override
    public int getColumnCount() {
      return 11;
    }

    @Override
    public Object getValueAt(int row, int column) {
      switch (column) {
        case ID_COLUMN_ID:
          return getID(row);
        case SUMMARY_COLUMN_ID:
          return getSummary(row);
        case LAST_CHANGED_COLUMN_ID:
          return getLastChanged(row);
        case SEVERETY_COLUMN_ID:
          return getSeverety(row);
        case PRIORITY_COLUMN_ID:
          return getPriority(row);
        case TARGET_MILESTONE_COLUMN_ID:
          return getTargetMilestone(row);
        case STATUS_COLUMN_ID:
          return getStatus(row);
        case RESOLUTION_COLUMN_ID:
          return getResolution(row);
        case COMPONENT_COLUMN_ID:
          return getComponent(row);
        case ASSIGNEE_COLUMN_ID:
          return getAssignee(row);
        case SORT_VALUE_COLUMN_ID:
          return getSortValue(row);
        default:
          return null;
      }
    }

    @Override
    public void setValueAt(int row, int column, Object value) {
      switch (column) {
        case ID_COLUMN_ID:
          setID(row, (String) value);
          break;
        case SUMMARY_COLUMN_ID:
          setSummary(row, (String) value);
          break;
        case LAST_CHANGED_COLUMN_ID:
          setLastChanged(row, (String) value);
          break;
        case SEVERETY_COLUMN_ID:
          setSeverety(row, (String) value);
          break;
        case PRIORITY_COLUMN_ID:
          setPriority(row, (String) value);
          break;
        case TARGET_MILESTONE_COLUMN_ID:
          setTargetMilestone(row, (String) value);
          break;
        case STATUS_COLUMN_ID:
          setStatus(row, (String) value);
          break;
        case RESOLUTION_COLUMN_ID:
          setResolution(row, (String) value);
          break;
        case COMPONENT_COLUMN_ID:
          setComponent(row, (String) value);
          break;
        case ASSIGNEE_COLUMN_ID:
          setAssignee(row, (String) value);
          break;
        case SORT_VALUE_COLUMN_ID:
          setSortValue(row, (Integer) value);
          break;
      }
    }
  }

  public static class Product extends AbstractValueFieldData<String> {
    private static final long serialVersionUID = 1L;

    public Product() {
    }

    /**
     * list of derived validation rules.
     */
    @Override
    protected void initValidationRules(java.util.Map<String, Object> ruleMap) {
      super.initValidationRules(ruleMap);
      ruleMap.put(ValidationRule.MAX_LENGTH, 4000);
    }
  }
}
