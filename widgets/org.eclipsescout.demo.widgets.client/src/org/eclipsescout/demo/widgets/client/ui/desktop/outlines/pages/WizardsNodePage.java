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
package org.eclipsescout.demo.widgets.client.ui.desktop.outlines.pages;

import java.util.Collection;

import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.rt.client.ui.desktop.outline.pages.AbstractPageWithNodes;
import org.eclipse.scout.rt.client.ui.desktop.outline.pages.IPage;
import org.eclipse.scout.rt.shared.TEXTS;
import org.eclipsescout.demo.widgets.client.ui.wizards.DynamicFormWizard;
import org.eclipsescout.demo.widgets.client.ui.wizards.LabelWizard;

public class WizardsNodePage extends AbstractPageWithNodes {

  @Override
  protected String getConfiguredIconId() {
    return org.eclipsescout.demo.widgets.shared.Icons.Wizards;
  }

  @Override
  protected String getConfiguredTitle() {
    return TEXTS.get("Wizards");
  }

  @Override
  protected void execCreateChildPages(Collection<IPage> pageList) throws ProcessingException {

    WizardPage wizardPage = new WizardPage(LabelWizard.class);
    pageList.add(wizardPage);
    WizardPage wizardPage0 = new WizardPage(DynamicFormWizard.class);
    pageList.add(wizardPage0);
  }
}
