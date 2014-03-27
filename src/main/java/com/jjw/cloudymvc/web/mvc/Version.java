/*
 * Copyright (c) 2010-2014.
 * Cloud Elements LLC. All rights reserved. CLOUD ELEMENTS PROPRIETARY/CONFIDENTIAL.
 * Use is subject to license terms.
 */

package com.jjw.cloudymvc.web.mvc;


import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * The enumeration which keeps track of all of the viable API versions we currently support in our system
 *
 * @author jjwyse
 * @version %I%, %G%
 */
public enum Version{

    ONE(1, "one");

    /**
     * The number of this API version
     */
    private int versionNumber;

    /**
     * The name of this API version
     */
    private String versionName;

    /**
     * Only constructor that takes in the version number and version name for this API version
     *
     * @param versionNumber The number of the API version
     * @param versionName The name of the API version
     */
    Version(int versionNumber, String versionName) {
        this.versionNumber = versionNumber;
        this.versionName = versionName;
    }

    public String getVersionName() {
        return this.versionName;
    }

    public int getVersionNumber() {
        return this.versionNumber;
    }

    /**
     * Returns the enumeration for the given API version name
     *
     * @param versionName The name of the API version
     * @return The enumeration for this API version name or null if none exists
     */
    public static Version fromVersionName(String versionName) {
        if (StringUtils.isEmpty(versionName)) {
            return null;
        }

        for (Version elementApiVersion : Version.values()) {
            if (StringUtils.equalsIgnoreCase(versionName, elementApiVersion.versionName)) {
                return elementApiVersion;
            }
        }

        return null;
    }

    /**
     * Returns the enumeration for the given API version number
     *
     * @param versionNumber The number of the API version
     * @return The enumeration for this API version name or null if none exists
     */
    public static Version fromVersionNumber(int versionNumber) {
        if (versionNumber < 1) {
            return null;
        }

        for (Version elementApiVersion : Version.values()) {
            if (elementApiVersion.versionNumber == versionNumber) {
                return elementApiVersion;
            }
        }

        return null;
    }

    /**
     * {@inheritDoc}
     *
     * Returns the version name
     */
    @Override
    public String toString() {
        return this.versionName;
    }
}
