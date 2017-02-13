"use strict";

var cetelem = window.cetelem || {};

cetelem.device = (function (obj, $) {

  var
    // Private variables
    _ = {
      lastWindowHeight : 0,
      lastWindowWidth : 0,
      lastDevice : '',
      _getDevice : function(width) {
        switch (true) {
          case (width <= 800):
            return 'mobile';
          case (width > 800):
            return 'desktop';
        }
      }
    },

    // Public variables
    object = $.extend(obj, {
      NAME : 'cetelem.device',
    });


    /**
     * getCurrentWidth
     *    Get the width of the page. There is a fallback for IE8
     *
     * return
     *    numerical value of the width
     *
     */
    object.getCurrentWidth = function () {
      return window.innerWidth || document.documentElement.clientWidth;
    };

    /**
     * getCurrentHeight
     *    Get the height of the page. There is a fallback for IE8
     *
     * return
     *    numerical value of the height
     *
     */
    object.getCurrentHeight = function () {
      return window.innerHeight;
    };

    /**
     * updateLastResolution
     *    Update previous resolution
     *
     */
    object.updateLastResolution = function () {
      _.lastWindowHeight = object.getCurrentHeight();
      _.lastWindowWidth = object.getCurrentWidth();
    };

    /**
     * updateLastDevice
     *    Update previous device
     *
     */
    object.updateLastDevice = function () {
      _.lastDevice = object.getDevice();
    };

    /**
     * wasResized
     *    Function to let you know if the page was resized
     *
     * return
     *    true | false
     *
     */
    object.wasResized = function () {
      return (object.getCurrentHeight() != _.lastWindowHeight || object.getCurrentWidth() != _.lastWindowWidth);
    };

    /**
     * wasChangedDevice
     *    Function to let you know if the device changed
     *
     * return
     *    true | false
     *
     */
    object.wasChangedDevice = function () {
      var changed = (object.getDevice() != _.lastDevice);
      object.updateLastDevice();

      return changed;
    };

    /**
     * getDevice
     *    Function to get the current device according breakpoints
     *
     * return
     *    mobile | tablet | desktop
     *
     */
    object.getDevice = function () {
      var currentDevice = _._getDevice(object.getCurrentWidth());

      return currentDevice;
    };

    /**
     * getUserAgent
     *    Function to get the current user agent
     *
     * return
     *    mobile-device | tablet-device
     *
     */
    object.getUserAgent = function () {
      var userAgent = navigator.userAgent,
          mobile_browser = new Object();

      mobile_browser.type = 'desktop';
      mobile_browser.group = '';

      switch (true) {
          case (userAgent.match(/iPad/i) != null):
            mobile_browser.type = 'tablet-device';
            mobile_browser.group = 'ipad';
            break;
          case (userAgent.match(/ipod/i) != null):
            mobile_browser.type = 'mobile-device';
            mobile_browser.group = 'ipod';
            break;
          case (userAgent.match(/iphone/i) != null):
            mobile_browser.type = 'mobile-device';
            mobile_browser.group = 'iphone';
            break;
          case (userAgent.match(/android/i) != null):
            if (userAgent.match(/android 3./i) != null || userAgent.match(/mobile/i) == null) {
              mobile_browser.type = 'tablet-device';
              mobile_browser.group = 'galaxytab';
            }
            else{
              mobile_browser.type = 'mobile-device';
              mobile_browser.group = 'android';
            }
            break;
          case (userAgent.match(/opera mini/i) != null):
            mobile_browser.type = 'mobile-device';
            mobile_browser.group = 'opera_mini';
            break;
          case (userAgent.match(/blackberry/i) != null):
            mobile_browser.type = 'mobile-device';
            mobile_browser.group = 'blackberry';
            break;
          case (userAgent.match(/windows phone/i) != null):
            mobile_browser.type = 'mobile-device';
            mobile_browser.group = 'windowsphone';
            break;
      }

      return mobile_browser;
    };

    object.updateLastResolution();
    object.updateLastDevice();

    return object;

}(cetelem.device, jQuery));

jQuery(window).resize(function() {
  /* Just Call once */
  if(cetelem.device.wasChangedDevice()) {
    /* trigger the dependents functions */
    jQuery(document).trigger('wasChangedDeviceTrigger');
  }
});
