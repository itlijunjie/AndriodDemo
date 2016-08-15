LOCAL_PATH :=$(call my-dir)
include $(CLEAR_VARS)
LOCAL_MODULE :=MyJniLib
LOCAL_SRC_FILES=MyJniLib.c
include $(BUILD_SHARED_LIBRARY)