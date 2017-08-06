package me.blog.eyeballs.davidsprofile;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private CircleImageView facePic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        facePic = (CircleImageView) navigationView.getHeaderView(0).findViewById(R.id.facePicture);
        Picasso.with(this)
                .load("http://postfiles8.naver.net/MjAxNzA4MDZfMyAg/MDAxNTAyMDIxNjc5ODQ5.HfsX3lvpNGOhMkpy2nSo6tgkXsfitXdx9sO0KrMRf8Ug.cBA3LprM3FQDEIuPsvA-FpYyOe9S06DHXr229ZQolPog.PNG.eyeballss/%EB%8B%A4%EC%9A%B4%EB%A1%9C%EB%93%9C.png?type=w2")
                .error(R.mipmap.ic_launcher)
                .into(facePic);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Fragment fragment = null;
        String title=null;

        if (id == R.id.nav_profile) {
            // Handle the camera action
            fragment = new ProfileFragment();
            title="Profile";
        } else if (id == R.id.nav_gallery) {
            fragment = new GalleryFragment();
            title="Gallery";
        } else if (id == R.id.nav_projects) {
            fragment = new ProjectsFragment();
            title="Projects";

        } else if (id == R.id.nav_activities) {
            fragment = new ActivitiesFragment();
            title="Activities";

        } else if (id == R.id.nav_send_email) {
            fragment = new EmailFragment();
            title="Email";
        }

        if (fragment != null) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.content_fragment_layout, fragment);
            fragmentTransaction.commit();

        }

        if(getSupportActionBar()!=null){
            getSupportActionBar().setTitle(title);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
