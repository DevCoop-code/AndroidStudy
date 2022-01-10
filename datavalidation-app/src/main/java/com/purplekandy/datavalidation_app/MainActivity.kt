package com.purplekandy.datavalidation_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.purplekandy.annotation.validate
import com.purplekandy.datavalidation_app.data.Book
import com.purplekandy.datavalidation_app.data.Publisher
import java.lang.StringBuilder

// https://blog.gangnamunni.com/post/kotlin-annotation-codegeneration
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val book: Book = Book("Hello", 10, "coop", "coop@gmail.com", Publisher("coop"))
        Log.v("MainActivity", "Annotation: ${book.title}")

        val validationResult = book.validate()
        Log.v("Validation", StringBuilder().appendln("유효성: ${validationResult.isValid}")
            .appendln("잘못된 필드: ${validationResult.invalidFieldNameAndTags.joinToString(", ", transform = {it.fieldName})}")
            .appendln("메시지: ${validationResult.invalidFieldNameAndTags.joinToString(" & ", transform = { it.tag})}")
            .toString())
    }
}