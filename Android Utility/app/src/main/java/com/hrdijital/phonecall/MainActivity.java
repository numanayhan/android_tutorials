package com.hrdijital.phonecall;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.gun0912.tedpermission.TedPermission;

import java.util.List;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;
import static android.Manifest.permission_group.CAMERA;
interface PermissionListener extends com.gun0912.tedpermission.PermissionListener {

    void onPermissionGranted();

    void onPermissionDenied(List<String> deniedPermissions);

}
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            PermissionListener permissionlistener = new PermissionListener() {
                @Override
                public void onPermissionGranted() {
                    Toast.makeText(MainActivity.this, "Permission Granted", Toast.LENGTH_SHORT).show();
                }
                @Override
                public void onPermissionDenied(List<String> deniedPermissions) {
                    Toast.makeText(MainActivity.this, "Permission Granted", Toast.LENGTH_SHORT).show();
                }
            };
            TedPermission.with(this)
                    .setPermissionListener(permissionlistener)
                    .setRationaleTitle("DijitalSDK")
                    .setRationaleMessage(getString(R.string.permision))
                    .setDeniedTitle(getString(R.string.cancel))
                    .setDeniedMessage(getString(R.string.permision_dont_ask_again))
                    .setGotoSettingButtonText(getString(R.string.ok))
                    .setPermissions(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE )
                    .check();

        } catch (Exception error) {
            error.getMessage();
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case 0: {
                for (int i = 0; i < permissions.length; i++) {
                    if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                        Log.d("TAG", String.valueOf(grantResults[i]));
                    } else if (grantResults[i] == PackageManager.PERMISSION_DENIED) {
                        PermissionUtils.setShouldShowStatus(this, Manifest.permission.CAMERA);
                        PermissionUtils.setShouldShowStatus(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
                        PermissionUtils.setShouldShowStatus(this, Manifest.permission.READ_EXTERNAL_STORAGE);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            if (PermissionUtils.neverAskAgainSelected(this, Manifest.permission.CAMERA)) {
                                statusDialog();
                            } else if (PermissionUtils.neverAskAgainSelected(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                                statusDialog();
                            } else if (PermissionUtils.neverAskAgainSelected(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
                                statusDialog();
                            } else {
                                String[] permissionss = new String[]{CAMERA, WRITE_EXTERNAL_STORAGE, READ_EXTERNAL_STORAGE};
                                ActivityCompat.requestPermissions( this, permissionss, 0);
                            }
                        }
                    }
                }
            }
            break;
            default: {
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
            }
        }
    }
    private void statusDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(R.string.permision_dont_ask_again));
        builder.setCancelable(false);
        builder.setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                Intent intent = new Intent();
                intent.setAction(android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                Uri uri = Uri.fromParts("package", getPackageName(), null);
                intent.setData(uri);
                startActivity(intent);
            }
        });
        builder.setNegativeButton(getString(R.string.cancel), null);
        builder.show();
    }

}