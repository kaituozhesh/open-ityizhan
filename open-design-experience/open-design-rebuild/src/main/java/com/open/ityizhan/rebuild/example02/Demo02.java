package com.open.ityizhan.rebuild.example02;

/**
 * @Description:
 * @ClassName: Demo02
 * @Auther: lin
 * @Date: 2024/8/5 11:03
 * @Version: 1.0
 */
public class Demo02 {

    private static String platform, browser;
    private static int resize;

    class version01 {
        void x() {
            if ((platform.toUpperCase().indexOf("MAC") > -1) && (browser.toUpperCase().indexOf("IE") > -1) && wasInitialized() && resize > 0) {
                // do something
            }
        }
    }

    class version02 {
        void x() {

            final boolean isMacOS = platform.toUpperCase().indexOf("MAC") > -1;
            final boolean isIE = browser.toUpperCase().indexOf("IE") > -1;
            final boolean wasResized = resize > 0;

            if (isMacOS && isIE && wasInitialized() && wasResized) {
                // do something
            }
        }
    }

    boolean wasInitialized() {
        return false;
    }
}
