package com.example.tuitionz;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Window;
import android.widget.Toast;
import com.google.android.material.bottomnavigation.BottomNavigationView;
public class MainActivity extends AppCompatActivity {
    BottomNavigationView btnnav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnnav=findViewById(R.id.btnView);
        btnnav.setOnItemSelectedListener(item -> {
            int id=item.getItemId();
            if (id==R.id.home){
                loadFrag(new HomeFragment(),true);
            } else if (id==R.id.add) {
                Toast.makeText(MainActivity.this, "Filters Are Applied", Toast.LENGTH_SHORT).show();
            }
            else {
                loadFrag(new ProfileFragment(),false);
            }
            return true;
        });
        btnnav.setSelectedItemId(R.id.home);
    }
    public void loadFrag(Fragment fragment,Boolean flag){
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        if (flag)
        ft.add(R.id.container,fragment);
        else
            ft.replace(R.id.container,fragment);
        ft.commit();
    }
}
