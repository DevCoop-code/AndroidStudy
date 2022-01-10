package com.purplekandy.datavalidation_app.data

import com.purplekandy.datavalidation_annotation.DataValidation
import com.purplekandy.datavalidation_annotation.MaxLength

@DataValidation
data class Publisher(
    @MaxLength(10, "publisher name is too long")
    val name: String
)