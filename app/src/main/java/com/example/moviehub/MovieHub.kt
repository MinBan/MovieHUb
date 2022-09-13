package com.example.moviehub


import android.os.Build
import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.RequiresApi


class MovieHub(
    val name: String?,
    private val img_path: String?,
    private val release_date: String?,
    private val user_score: Double?,

    //detail data
    private val overview: String?,
    private val popularity: String?,
    private val adult: Boolean?
) : Parcelable {
    @RequiresApi(Build.VERSION_CODES.Q)
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readString(),
        parcel.readString(),
        parcel.readBoolean()
    ) {
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(img_path)
        parcel.writeString(release_date)
        parcel.writeValue(user_score)
        parcel.writeString(overview)
        parcel.writeString(popularity)
        if (adult != null) {
            parcel.writeBoolean(adult)
        }
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Movie> {
        @RequiresApi(Build.VERSION_CODES.Q)
        override fun createFromParcel(parcel: Parcel): Movie {
            return Movie(parcel)
        }

        private fun Movie(movieId: Parcel): Movie {
            TODO("Not yet implemented")
        }

        override fun newArray(size: Int): Array<Movie?> {
            return arrayOfNulls(size)
        }
    }
}