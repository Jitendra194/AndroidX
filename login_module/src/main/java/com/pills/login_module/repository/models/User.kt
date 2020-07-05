package com.pills.login_module.repository.models

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("Date_of_Birth__c") val Date_of_Birth__c: String,
    @SerializedName("Email__c") val Email__c: String,
    @SerializedName("First_Name__c") val First_Name__c: String,
    @SerializedName("Full_Name__c") val Full_Name__c: String,
    @SerializedName("Gender__c") val Gender__c: String,
    @SerializedName("Id") val Id: String,
    @SerializedName("Last_Name__c") val Last_Name__c: String,
    @SerializedName("Mobile_Number__c") val Mobile_Number__c: String,
    @SerializedName("Status__c") val Status__c: String
)