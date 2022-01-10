package com.purplekandy.androidstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Log.v
import com.purplekandy.androidstudy.data.Book
import com.purplekandy.androidstudy.data.Publisher
import java.util.logging.Logger
import kotlin.reflect.KMutableProperty
import kotlin.reflect.full.createInstance
import kotlin.reflect.full.memberFunctions
import kotlin.reflect.full.memberProperties

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"

    @Deprecated("")
    class A {
        var field1 = ""
        var field2 = 0
        fun function1() {}
        fun function2() {}
    }

    // kClass는 Reflection을 사용하는 기본적인 방법
    fun kClassTest() {
        val receiverA = A()
        val kClass = A::class

        // Class Meta Data
        kClass.simpleName?.let { Log.v(TAG, it) }
        kClass.isData?.let { Log.v(TAG, it.toString()) }
        kClass.isAbstract?.let { Log.v(TAG, it.toString()) }
        kClass.isCompanion?.let { Log.v(TAG, it.toString()) }
        kClass.isFinal?.let { Log.v(TAG, it.toString()) }
        kClass.isInner?.let { Log.v(TAG, it.toString()) }
        kClass.isOpen?.let { Log.v(TAG, it.toString()) }
        kClass.isSealed?.let { Log.v(TAG, it.toString()) }

        // Create Instance
        Log.v(TAG, kClass.createInstance().toString())

        // Constructor
        Log.v(TAG, kClass.constructors.map { it.name }.toString())
        Log.v(TAG, kClass.constructors.map { it.parameters }.toString())
        Log.v(TAG, kClass.constructors.map { it.call() }.toString())

        // Annotation
        Log.v(TAG, kClass.annotations.map { it.annotationClass.simpleName }.toString())

        // Fields
        val kProperty = kClass.memberProperties.find { it.name == "field1" }
        (kProperty as KMutableProperty<String>).setter.call(receiverA, "Changed Field1 Value")
        Log.v(TAG, receiverA.field1)

        // Functions
        Log.v(TAG, kClass.memberFunctions.map { it.name }.toString())
        val value = kClass.memberFunctions.find { it.name == "function1" }?.call(receiverA) ?: ""
        if (value is String)
            Log.v(TAG, value)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        kClassTest()
    }
}