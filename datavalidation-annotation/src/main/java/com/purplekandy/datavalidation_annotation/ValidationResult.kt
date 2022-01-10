package com.purplekandy.datavalidation_annotation

data class ValidationResult(var isValid: Boolean = true,
                            val invalidFieldNameAndTags: MutableList<FieldNameAndTag> = mutableListOf())