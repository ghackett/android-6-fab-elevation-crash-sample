Sample app showing a native crash on android 5.1 and 6.0 when trying to animate `FloatingActionButton.setCompatElevation()`

Crash occurs in [MainActivity](src/main/java/com/example/testapp/MainActivity.java#L30) `onPostResume`

Crash occurs 100% of the time on android 5.1 and 6.0

Android 5.1 Stack Trace:
```
F/art     ( 1975): art/runtime/check_jni.cc:65] JNI DETECTED ERROR IN APPLICATION: can't call void android.view.View.setElevation(float) on null object
F/art     ( 1975): art/runtime/check_jni.cc:65]     in call to CallVoidMethodV
F/art     ( 1975): art/runtime/check_jni.cc:65]     from void android.animation.PropertyValuesHolder.nCallFloatMethod(java.lang.Object, long, float)
F/art     ( 1975): art/runtime/check_jni.cc:65] "main" prio=5 tid=1 Runnable
F/art     ( 1975): art/runtime/check_jni.cc:65]   | group="main" sCount=0 dsCount=0 obj=0x74039000 self=0xf3c25800
F/art     ( 1975): art/runtime/check_jni.cc:65]   | sysTid=1975 nice=0 cgrp=default sched=0/0 handle=0xf77bdea0
F/art     ( 1975): art/runtime/check_jni.cc:65]   | state=R schedstat=( 188728744 9730356 138 ) utm=7 stm=11 core=1 HZ=100
F/art     ( 1975): art/runtime/check_jni.cc:65]   | stack=0xff566000-0xff568000 stackSize=8MB
F/art     ( 1975): art/runtime/check_jni.cc:65]   | held mutexes= "mutator lock"(shared held)
F/art     ( 1975): art/runtime/check_jni.cc:65]   native: #00 pc 00005d03  /system/lib/libbacktrace_libc++.so (UnwindCurrent::Unwind(unsigned int, ucontext*)+83)
F/art     ( 1975): art/runtime/check_jni.cc:65]   native: #01 pc 00003051  /system/lib/libbacktrace_libc++.so (Backtrace::Unwind(unsigned int, ucontext*)+33)
F/art     ( 1975): art/runtime/check_jni.cc:65]   native: #02 pc 003c9b97  /system/lib/libart.so (art::DumpNativeStack(std::__1::basic_ostream<char, std::__1::char_traits<char> >&, int, char const*, art::mirror::ArtMethod*)+135)
F/art     ( 1975): art/runtime/check_jni.cc:65]   native: #03 pc 00392f52  /system/lib/libart.so (art::Thread::Dump(std::__1::basic_ostream<char, std::__1::char_traits<char> >&) const+306)
F/art     ( 1975): art/runtime/check_jni.cc:65]   native: #04 pc 001029bb  /system/lib/libart.so (art::JniAbort(char const*, char const*)+1019)
F/art     ( 1975): art/runtime/check_jni.cc:65]   native: #05 pc 0010359c  /system/lib/libart.so (art::JniAbortF(char const*, char const*, ...)+108)
F/art     ( 1975): art/runtime/check_jni.cc:65]   native: #06 pc 00104ae3  /system/lib/libart.so (art::ScopedCheck::CheckVirtualMethod(_jobject*, _jmethodID*)+691)
F/art     ( 1975): art/runtime/check_jni.cc:65]   native: #07 pc 00113fdf  /system/lib/libart.so (art::CheckJNI::CallVoidMethodV(_JNIEnv*, _jobject*, _jmethodID*, char*)+143)
F/art     ( 1975): art/runtime/check_jni.cc:65]   native: #08 pc 000773d9  /system/lib/libandroid_runtime.so (_JNIEnv::CallVoidMethod(_jobject*, _jmethodID*, ...)+41)
F/art     ( 1975): art/runtime/check_jni.cc:65]   native: #09 pc 00124279  /system/lib/libandroid_runtime.so (???)
F/art     ( 1975): art/runtime/check_jni.cc:65]   native: #10 pc 0008c70a  /data/dalvik-cache/x86/system@framework@boot.oat (Java_android_animation_PropertyValuesHolder_nCallFloatMethod__Ljava_lang_Object_2JF+174)
F/art     ( 1975): art/runtime/check_jni.cc:65]   at android.animation.PropertyValuesHolder.nCallFloatMethod(Native method)
F/art     ( 1975): art/runtime/check_jni.cc:65]   at android.animation.PropertyValuesHolder.access$400(PropertyValuesHolder.java:39)
F/art     ( 1975): art/runtime/check_jni.cc:65]   at android.animation.PropertyValuesHolder$FloatPropertyValuesHolder.setAnimatedValue(PropertyValuesHolder.java:1298)
F/art     ( 1975): art/runtime/check_jni.cc:65]   at android.animation.ObjectAnimator.animateValue(ObjectAnimator.java:956)
F/art     ( 1975): art/runtime/check_jni.cc:65]   at android.animation.ValueAnimator.animationFrame(ValueAnimator.java:1298)
F/art     ( 1975): art/runtime/check_jni.cc:65]   at android.animation.ValueAnimator.doAnimationFrame(ValueAnimator.java:1339)
F/art     ( 1975): art/runtime/check_jni.cc:65]   at android.animation.ValueAnimator$AnimationHandler.doAnimationFrame(ValueAnimator.java:715)
F/art     ( 1975): art/runtime/check_jni.cc:65]   at android.animation.ValueAnimator$AnimationHandler.run(ValueAnimator.java:738)
F/art     ( 1975): art/runtime/check_jni.cc:65]   at android.view.Choreographer$CallbackRecord.run(Choreographer.java:767)
F/art     ( 1975): art/runtime/check_jni.cc:65]   at android.view.Choreographer.doCallbacks(Choreographer.java:580)
F/art     ( 1975): art/runtime/check_jni.cc:65]   at android.view.Choreographer.doFrame(Choreographer.java:549)
F/art     ( 1975): art/runtime/check_jni.cc:65]   at android.view.Choreographer$FrameDisplayEventReceiver.run(Choreographer.java:753)
F/art     ( 1975): art/runtime/check_jni.cc:65]   at android.os.Handler.handleCallback(Handler.java:739)
F/art     ( 1975): art/runtime/check_jni.cc:65]   at android.os.Handler.dispatchMessage(Handler.java:95)
F/art     ( 1975): art/runtime/check_jni.cc:65]   at android.os.Looper.loop(Looper.java:135)
F/art     ( 1975): art/runtime/check_jni.cc:65]   at android.app.ActivityThread.main(ActivityThread.java:5254)
F/art     ( 1975): art/runtime/check_jni.cc:65]   at java.lang.reflect.Method.invoke!(Native method)
F/art     ( 1975): art/runtime/check_jni.cc:65]   at java.lang.reflect.Method.invoke(Method.java:372)
F/art     ( 1975): art/runtime/check_jni.cc:65]   at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:903)
F/art     ( 1975): art/runtime/check_jni.cc:65]   at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:698)
```

Android 6.0 Stack Trace:
```
05-08 11:10:12.662  3735  3735 F art     : art/runtime/java_vm_ext.cc:410] JNI DETECTED ERROR IN APPLICATION: can't call void android.view.View.setElevation(float) on null object
05-08 11:10:12.662  3735  3735 F art     : art/runtime/java_vm_ext.cc:410]     in call to CallVoidMethodV
05-08 11:10:12.662  3735  3735 F art     : art/runtime/java_vm_ext.cc:410]     from void android.animation.PropertyValuesHolder.nCallFloatMethod(java.lang.Object, long, float)
05-08 11:10:12.662  3735  3735 F art     : art/runtime/java_vm_ext.cc:410] "main" prio=5 tid=1 Runnable
05-08 11:10:12.662  3735  3735 F art     : art/runtime/java_vm_ext.cc:410]   | group="main" sCount=0 dsCount=0 obj=0x753a9f68 self=0xf3d74a00
05-08 11:10:12.662  3735  3735 F art     : art/runtime/java_vm_ext.cc:410]   | sysTid=3735 nice=0 cgrp=default sched=0/0 handle=0xf776bc00
05-08 11:10:12.662  3735  3735 F art     : art/runtime/java_vm_ext.cc:410]   | state=R schedstat=( 191587834 43529682 241 ) utm=10 stm=8 core=3 HZ=100
05-08 11:10:12.662  3735  3735 F art     : art/runtime/java_vm_ext.cc:410]   | stack=0xff7ad000-0xff7af000 stackSize=8MB
05-08 11:10:12.662  3735  3735 F art     : art/runtime/java_vm_ext.cc:410]   | held mutexes= "mutator lock"(shared held)
05-08 11:10:12.662  3735  3735 F art     : art/runtime/java_vm_ext.cc:410]   native: #00 pc 0058b112  /system/lib/libart.so (art::DumpNativeStack(std::__1::basic_ostream<char, std::__1::char_traits<char> >&, int, char const*, art::ArtMethod*, void*)+226)
05-08 11:10:12.662  3735  3735 F art     : art/runtime/java_vm_ext.cc:410]   native: #01 pc 00550d5e  /system/lib/libart.so (art::Thread::Dump(std::__1::basic_ostream<char, std::__1::char_traits<char> >&) const+286)
05-08 11:10:12.662  3735  3735 F art     : art/runtime/java_vm_ext.cc:410]   native: #02 pc 003a48cf  /system/lib/libart.so (art::JavaVMExt::JniAbort(char const*, char const*)+1247)
05-08 11:10:12.662  3735  3735 F art     : art/runtime/java_vm_ext.cc:410]   native: #03 pc 003a5f4c  /system/lib/libart.so (art::JavaVMExt::JniAbortV(char const*, char const*, char*)+116)
05-08 11:10:12.662  3735  3735 F art     : art/runtime/java_vm_ext.cc:410]   native: #04 pc 00163a40  /system/lib/libart.so (art::ScopedCheck::AbortF(char const*, ...)+62)
05-08 11:10:12.662  3735  3735 F art     : art/runtime/java_vm_ext.cc:410]   native: #05 pc 00163c85  /system/lib/libart.so (art::ScopedCheck::CheckMethodAndSig(art::ScopedObjectAccess&, _jobject*, _jclass*, _jmethodID*, art::Primitive::Type, art::InvokeType)+565)
05-08 11:10:12.662  3735  3735 F art     : art/runtime/java_vm_ext.cc:410]   native: #06 pc 001875c3  /system/lib/libart.so (art::CheckJNI::CallMethodV(char const*, _JNIEnv*, _jobject*, _jclass*, _jmethodID*, char*, art::Primitive::Type, art::InvokeType)+915)
05-08 11:10:12.662  3735  3735 F art     : art/runtime/java_vm_ext.cc:410]   native: #07 pc 001898fb  /system/lib/libart.so (art::CheckJNI::CallVoidMethodV(_JNIEnv*, _jobject*, _jmethodID*, char*)+92)
05-08 11:10:12.662  3735  3735 F art     : art/runtime/java_vm_ext.cc:410]   native: #08 pc 00073f2f  /system/lib/libandroid_runtime.so (_JNIEnv::CallVoidMethod(_jobject*, _jmethodID*, ...)+41)
05-08 11:10:12.662  3735  3735 F art     : art/runtime/java_vm_ext.cc:410]   native: #09 pc 00128818  /system/lib/libandroid_runtime.so (???)
05-08 11:10:12.662  3735  3735 F art     : art/runtime/java_vm_ext.cc:410]   native: #10 pc 009c6244  /data/dalvik-cache/x86/system@framework@boot.oat (Java_android_animation_PropertyValuesHolder_nCallFloatMethod__Ljava_lang_Object_2JF+168)
05-08 11:10:12.662  3735  3735 F art     : art/runtime/java_vm_ext.cc:410]   at android.animation.PropertyValuesHolder.nCallFloatMethod(Native method)
05-08 11:10:12.662  3735  3735 F art     : art/runtime/java_vm_ext.cc:410]   at android.animation.PropertyValuesHolder.-wrap4(PropertyValuesHolder.java:-1)
05-08 11:10:12.662  3735  3735 F art     : art/runtime/java_vm_ext.cc:410]   at android.animation.PropertyValuesHolder$FloatPropertyValuesHolder.setAnimatedValue(PropertyValuesHolder.java:1296)
05-08 11:10:12.662  3735  3735 F art     : art/runtime/java_vm_ext.cc:410]   at android.animation.ObjectAnimator.animateValue(ObjectAnimator.java:981)
05-08 11:10:12.662  3735  3735 F art     : art/runtime/java_vm_ext.cc:410]   at android.animation.ValueAnimator.animationFrame(ValueAnimator.java:1384)
05-08 11:10:12.662  3735  3735 F art     : art/runtime/java_vm_ext.cc:410]   at android.animation.ValueAnimator.doAnimationFrame(ValueAnimator.java:1427)
05-08 11:10:12.662  3735  3735 F art     : art/runtime/java_vm_ext.cc:410]   at android.animation.ValueAnimator$AnimationHandler.doAnimationFrame(ValueAnimator.java:759)
05-08 11:10:12.662  3735  3735 F art     : art/runtime/java_vm_ext.cc:410]   at android.animation.ValueAnimator$AnimationHandler$1.run(ValueAnimator.java:801)
05-08 11:10:12.662  3735  3735 F art     : art/runtime/java_vm_ext.cc:410]   at android.view.Choreographer$CallbackRecord.run(Choreographer.java:858)
05-08 11:10:12.662  3735  3735 F art     : art/runtime/java_vm_ext.cc:410]   at android.view.Choreographer.doCallbacks(Choreographer.java:670)
05-08 11:10:12.662  3735  3735 F art     : art/runtime/java_vm_ext.cc:410]   at android.view.Choreographer.doFrame(Choreographer.java:603)
05-08 11:10:12.662  3735  3735 F art     : art/runtime/java_vm_ext.cc:410]   at android.view.Choreographer$FrameDisplayEventReceiver.run(Choreographer.java:844)
05-08 11:10:12.662  3735  3735 F art     : art/runtime/java_vm_ext.cc:410]   at android.os.Handler.handleCallback(Handler.java:739)
05-08 11:10:12.662  3735  3735 F art     : art/runtime/java_vm_ext.cc:410]   at android.os.Handler.dispatchMessage(Handler.java:95)
05-08 11:10:12.662  3735  3735 F art     : art/runtime/java_vm_ext.cc:410]   at android.os.Looper.loop(Looper.java:148)
05-08 11:10:12.662  3735  3735 F art     : art/runtime/java_vm_ext.cc:410]   at android.app.ActivityThread.main(ActivityThread.java:5417)
05-08 11:10:12.662  3735  3735 F art     : art/runtime/java_vm_ext.cc:410]   at java.lang.reflect.Method.invoke!(Native method)
05-08 11:10:12.662  3735  3735 F art     : art/runtime/java_vm_ext.cc:410]   at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:726)
05-08 11:10:12.662  3735  3735 F art     : art/runtime/java_vm_ext.cc:410]   at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:616)

```
