#include <jni.h>
#include <string>

extern "C"
JNIEXPORT jint JNICALL Java_top_icespite_fridahooker_shell_NativeShell_execute(JNIEnv *env, jclass type, jstring cmd) {
    const char * ccmd = env->GetStringUTFChars(cmd, nullptr);
    int ret_code = system(ccmd);
    env->ReleaseStringUTFChars(cmd, ccmd);
    return ret_code;
}