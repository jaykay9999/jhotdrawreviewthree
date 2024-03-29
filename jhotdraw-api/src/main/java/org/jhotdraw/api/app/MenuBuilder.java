/*
 * @(#)MenuBuilder.java
 *
 * Copyright (c) 2010 The authors and contributors of JHotDraw.
 *
 * You may not use, copy or modify this file, except in compliance with the
 * accompanying license terms.
 */
package org.jhotdraw.api.app;

import java.util.List;
import javax.swing.JMenu;

/**
 * {@code MenuBuilder} is used by {@link Application} to build to build its menu bar(s) and popup
 * menu(s).
 *
 * <p>Each method adds a logical group of menu items to a menu provided by the {@code Application}.
 *
 * <p>Implementors of this interface typically use actions retrieved from the application to build
 * the menu items. See DefaultMenuBuilder for a typical implementation.
 *
 * <p>Menus may be associated to a specific view or to all views (global) of the application. In the
 * former case the corresponding view is provided, in the latter case null is passed. Note that some
 * applications, specifically OSXApplication, need to create both kinds of menus.
 *
 * <p>During the lifetime of an application many menus may be created and destroyed. Implementors
 * must ensure that menu items can be garbage collected.
 *
 * <p><hr> <b>Design Patterns</b>
 *
 * <p><em>Abstract Factory</em><br>
 * {@code MenuBuilder} is used by {@code Application} for creating menu items. The {@code
 * MenuBuilder} is provided by {@code ApplicationModel}. Abstract Factory: {@link MenuBuilder}<br>
 * Client: {@link Application}. <hr>
 */
public interface MenuBuilder {

  /**
   * Optionally adds one or more "Preferences" items to a menu.
   *
   * <p>Most applications use this method for adding items to the last section of the "Edit" menu.
   *
   * <p>Note that OSXApplication does <b>not</b> invoke this method and instead retrieves an action
   * with ID {@code AbstractPreferencesAction.ID} from the action map of the {@code
   * ApplicationModel} and adds it to the "Application" menu.
   *
   * @param m A (potentially non-empty) menu.
   * @param app The Application for which the menu is built.
   * @param v A view the menu is used exclusively for a specific view, null if the menu is shared by
   *     all views.
   */
  void addPreferencesItems(JMenu m, Application app, View v);

  /**
   * Optionally adds one or more "Exit" items to a menu.
   *
   * <p>Note that OSXApplication does <b>not</b> invoke this method and instead retrieves an action
   * with ID {@code ExitAction.ID} from the action map of the {@code ApplicationModel} and adds it
   * to the "Application" menu.
   *
   * @param menu
   * @param application
   * @param viewMenu
   */
  void addExitItems(JMenu menu, Application application, View viewMenu);

  /**
   * Optionally adds one or more "Clear File" items to a menu.
   *
   * @param menu
   * @param application
   * @param viewMenu
   */
  void addClearFileItems(JMenu menu, Application application, View viewMenu);

  /**
   * Optionally adds one or more "New Window" items to a menu.
   *
   * @param menu
   * @param application
   * @param viewMenu
   */
  void addNewWindowItems(JMenu menu, Application application, View viewMenu);

  /**
   * Optionally adds one or more "New File" items to a menu.
   *
   * @param menu
   * @param application
   * @param viewMenu
   */
  void addNewFileItems(JMenu menu, Application application, View viewMenu);

  /**
   * Optionally adds one or more "Load file" items to a menu.
   *
   * @param menu
   * @param application
   * @param viewMenu
   */
  void addLoadFileItems(JMenu menu, Application application, View viewMenu);

  /**
   * Optionally adds one or more "Open File" items to a menu.
   *
   * @param menu
   * @param application
   * @param viewMenu
   */
  void addOpenFileItems(JMenu menu, Application application, View viewMenu);

  /**
   * Optionally adds one or more "Close File" items to a menu.
   *
   * @param menu
   * @param application
   * @param viewMenu
   */
  void addCloseFileItems(JMenu menu, Application application, View viewMenu);

  /**
   * Optionally adds one or more "Save File" items to a menu.
   *
   * @param menu
   * @param application
   * @param viewMenu
   */
  void addSaveFileItems(JMenu menu, Application application, View viewMenu);

  /**
   * Optionally adds one or more "Export File" items to a menu.
   *
   * @param menu
   * @param application
   * @param viewMenu
   */
  void addExportFileItems(JMenu menu, Application application, View viewMenu);

  /**
   * Optionally adds one or more "Print File" items to a menu.u.
   *
   * @param menu
   * @param application
   * @param viewMenu
   */
  void addPrintFileItems(JMenu menu, Application application, View viewMenu);

  /**
   * Optionally adds one or more file related items to a menu.
   *
   * @param menu
   * @param application
   * @param viewMenu
   */
  void addOtherFileItems(JMenu menu, Application application, View viewMenu);

  /**
   * Optionally adds one or more "Undo" items to a menu.
   *
   * @param menu
   * @param application
   * @param viewMenu
   */
  void addUndoItems(JMenu menu, Application application, View viewMenu);

  /**
   * Optionally adds one or more "Clipboard" items to a menu.
   *
   * @param menu
   * @param application
   * @param viewMenu
   */
  void addClipboardItems(JMenu menu, Application application, View viewMenu);

  /**
   * Optionally adds one or more "Selection" items to a menu.
   *
   * @param menu
   * @param application
   * @param viewMenu
   */
  void addSelectionItems(JMenu menu, Application application, View viewMenu);

  /**
   * Optionally adds one or more "Find" items to a menu.
   *
   * @param menu
   * @param application
   * @param viewMenu
   */
  void addFindItems(JMenu menu, Application application, View viewMenu);

  /**
   * Optionally adds one or more editing related items to a menu.
   *
   * @param menu
   * @param application
   * @param viewMenu
   */
  void addOtherEditItems(JMenu menu, Application application, View viewMenu);

  /**
   * Optionally adds one or more view related items to a menu.
   *
   * @param menu
   * @param application
   * @param viewMenu
   */
  void addOtherViewItems(JMenu menu, Application application, View viewMenu);

  /**
   * Optionally adds one or more additional menus to a menu bar or a pop up menu.
   *
   * @param menus A (potentially non-empty) list of menus.
   * @param application
   * @param viewMenu
   */
  void addOtherMenus(List<JMenu> menus, Application application, View viewMenu);

  /**
   * Optionally adds one or more window related items to a menu.
   *
   * @param menu
   * @param application
   * @param viewMenu
   */
  void addOtherWindowItems(JMenu menu, Application application, View viewMenu);

  /**
   * Optionally adds one or more "Help" items to a menu.
   *
   * @param menu
   * @param application
   * @param viewMenu
   */
  void addHelpItems(JMenu menu, Application application, View viewMenu);

  /**
   * Optionally adds one or more "About" items to a menu.
   *
   * <p>Note that OSXApplication does <b>not</b> invoke this method and instead retrieves an action
   * with ID {@code AboutAction.ID} from the action map of the {@code ApplicationModel} and adds it
   * to the "Application" menu.
   *
   * @param menu
   * @param application
   * @param viewMenu
   */
  void addAboutItems(JMenu menu, Application application, View viewMenu);
}

