package com.ant.gallerytestapp.util;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

import com.ant.gallerytestapp.models.Photo;
import com.ant.gallerytestapp.models.Photos;

/**
 * Created by mihailantipev on 29.01.18.
 */

public class PhotoHelper {

    public static Photos loadLocalPhotos(Context context) {
        Uri uri = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        String[] projection = {MediaStore.MediaColumns.DATA,
                MediaStore.Images.Media.BUCKET_DISPLAY_NAME,
                MediaStore.Images.Media.DISPLAY_NAME,
                MediaStore.Images.Media.SIZE
        };

        Cursor cursor = context.getContentResolver().query(uri, projection, null,
                null, null);

        int columnData = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
        int columnName = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DISPLAY_NAME);
        int columnSize = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.SIZE);
//        columnPath = cursor
//                .getColumnIndexOrThrow(MediaStore.Images.Media.BUCKET_DISPLAY_NAME);

        Photos list = new Photos();
        while (cursor.moveToNext())
            list.add(new Photo(
                    cursor.getString(columnData),
                    cursor.getString(columnName),
                    cursor.getInt(columnSize),
                    HashHelper.md5(cursor.getString(columnData))
            ));
        cursor.close();
        return list;
    }
}
