/*
 * @(#)Main.java
 *
 * Copyright (c) 1996-2010 The authors and contributors of JHotDraw.
 * You may not use, copy or modify this file, except in compliance with the
 * accompanying license terms.
 */
package org.jhotdraw.samples.svg;

import org.jhotdraw.api.app.Application;
import org.jhotdraw.app.OSXApplication;
import org.jhotdraw.app.SDIApplication;
import org.jhotdraw.util.ResourceBundleUtil;

/**
 * Main entry point of the SVG sample application. Creates an {@link Application} depending on the
 * operating system we run, sets the {@link SVGApplicationModel} and then launches the application.
 * The application then creates {@link SVGView}s and menu bars as specified by the application
 * model.
 *
 * @author Werner Randelshofer.
 * @version $Id$
 */
public class Main {

  public static void main(String[] args) {
    // Debug resource bundle
    ResourceBundleUtil.setVerbose(true);
    Application app;
    String os = System.getProperty("os.name").toLowerCase();
    
    // Check for Mac OS. The use of 'contains' instead of 'startsWith' ensures
    // broader compatibility with different Mac OS naming conventions.
    if (os.contains("mac")) {
        app = new OSXApplication();
    } else {
        // Default to SDIApplication for non-Mac OSes, including Windows.
        // Specific check for Windows OS is not needed as SDIApplication is the default.
        app = new SDIApplication();
    }

    SVGApplicationModel model = new SVGApplicationModel();
    model.setName("JHotDraw SVG");
    model.setVersion(Main.class.getPackage().getImplementationVersion());
    model.setCopyright(
        "Copyright 2006-2010 (c) by the authors of JHotDraw.\n"
            + "This software is licensed under LGPL and Creative Commons 3.0 Attribution.");
    model.setViewClassName("org.jhotdraw.samples.svg.SVGView");
    app.setModel(model);
    app.launch(args);
  }
}
