#include <string.h>
#include <jni.h>
#include "com_itlijunjie_andrioddemo1_ndk_NDKTest.h"


JNIEXPORT jstring JNICALL Java_com_itlijunjie_andrioddemo1_ndk_NDKTest_getString
        (JNIEnv *env, jobject thiz)
{
    return (*env)->NewStringUTF(env, "getString");
}