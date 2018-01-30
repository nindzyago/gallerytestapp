package com.ant.gallerytestapp.activities;

import android.Manifest;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ant.gallerytestapp.R;
import com.ant.gallerytestapp.adapters.MediaListAdapter;
import com.ant.gallerytestapp.models.Photos;
import com.ant.gallerytestapp.util.PhotoHelper;

import ru.alexbykov.nopermission.PermissionHelper;

public class MainActivity extends AppCompatActivity {

    private Photos photos;
    private MediaListAdapter adapter;
    private RecyclerView rvMedia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUI();
        checkPermissions();
    }

    private void setupUI() {
        rvMedia = findViewById(R.id.rvMedia);
    }

    private void checkPermissions() {
        PermissionHelper permissionHelper = new PermissionHelper(this);
        permissionHelper.check(Manifest.permission.READ_EXTERNAL_STORAGE)
                .onSuccess(this::onSuccess)
                .onDenied(this::onDenied)
                .onNeverAskAgain(this::onNeverAskAgain)
                .run();
    }

    private void onSuccess() {
        photos = PhotoHelper.loadLocalPhotos(this);
        setupRecyclerView();
    }

    private void onNeverAskAgain() {
        finish();
    }

    private void onDenied() {
        finish();
    }

    private void setupRecyclerView() {
        rvMedia.setLayoutManager(new GridLayoutManager(this, 4));
        rvMedia.setHasFixedSize(true);
        adapter = new MediaListAdapter(this, photos);
        rvMedia.setAdapter(adapter);
//        rvMedia.addItemDecoration(new GridSpacingItemDecoration(1, 5, true));
    }
}
