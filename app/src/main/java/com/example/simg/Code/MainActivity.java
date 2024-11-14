package com.example.simg.Code;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.simg.Models.DtoInfoLogin;
import com.example.simg.Models.DtoLogin;
import com.example.simg.R;
import com.example.simg.Retrofit.RetrofitAdapte;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    EditText et_usuario, et_contraseña;
    Button btn_ingresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        et_usuario = findViewById(R.id.et_usuario);
        et_contraseña = findViewById(R.id.et_contraseña);
        btn_ingresar = findViewById(R.id.et_ingresar);

        btn_ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciarsesion(et_usuario.getText().toString(), et_contraseña.getText().toString());

            }
        });

    }

    public void iniciarsesion(String usuario, String password) {
        DtoLogin oblog = new DtoLogin();
        oblog.setUsuario(usuario);
        oblog.setContraseña(password);

        Call<DtoInfoLogin> login = RetrofitAdapte.getService().login(oblog);
        login.enqueue(new Callback<DtoInfoLogin>() {
            @Override
            public void onResponse(Call<DtoInfoLogin> call, Response<DtoInfoLogin> response) {
                if (response.isSuccessful() && response.body() != null) {
                    DtoInfoLogin infologin = response.body();
                    if (password.equals(infologin.getUsuario())) {
                        Toast.makeText(MainActivity.this, "Usuario: " + infologin.getUsuario(), Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "La contraseña es incorrecta", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Log.i("Respuesta", "No se pudo iniciar sesion" + response.raw()
                    + response.errorBody());
                }
            }
            @Override
            public void onFailure(Call<DtoInfoLogin> call, Throwable throwable) {
                Log.e("Respuesta", "onFailure: " + throwable.getMessage() + throwable.getCause());
            }
        });


    }
}
