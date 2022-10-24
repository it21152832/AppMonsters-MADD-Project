package com.example.userlogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;

public class Dashboard extends AppCompatActivity {

    DrawerLayout layout;
    NavigationView nav;
    ActionBarDrawerToggle action;

    GoogleSignInOptions gso;
    GoogleSignInClient gsc;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (action.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(this , gso);

        layout = findViewById(R.id.drawer_layout);
        nav = findViewById(R.id.nav_view);
        action = new ActionBarDrawerToggle(Dashboard.this, layout, R.string.menu_open, R.string.close_menu);
        layout.addDrawerListener(action);
        action.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.nav_home:
                        Toast.makeText(Dashboard.this, "Home", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.nav_search:
                        Toast.makeText(Dashboard.this, "Search", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.nav_setting:
                        Toast.makeText(Dashboard.this, "Settings", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.nav_about:
                        Toast.makeText(Dashboard.this, "About", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.nav_rate:
                        Toast.makeText(Dashboard.this, "Rate Us", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.nav_share:
                        Toast.makeText(Dashboard.this, "Share", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.nav_signout:
                        signout();
                        break;

                    default:
                        throw new IllegalStateException("Unexpected value: " + item.getItemId());
                }

                return true;
            }
        });
    }

    private void signout() {
        gsc.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                finish();
                startActivity(new Intent(Dashboard.this, MainActivity.class));
            }
        });
    }


}