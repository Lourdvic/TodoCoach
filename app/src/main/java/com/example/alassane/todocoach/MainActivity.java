package com.example.alassane.todocoach;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText name;
    private Spinner spinner;
    private String moments[] = {"Matin", "Midi", "Après-midi", "Soir", "Journée"};
    ArrayAdapter<String> adapter;
    Coach coach = new Coach();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        coach.list.add(0, new TaskCategory("Aucun", "first"));
        Button button = findViewById(R.id.category_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                View view = getLayoutInflater().inflate(R.layout.layout_dialog, null);
                adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item,
                        getResources().getStringArray(R.array.journee));
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                name = view.findViewById(R.id.category_name);
                spinner = view.findViewById(R.id.spinner);
                spinner.setAdapter(adapter);
                builder.setView(view)
                        .setTitle("Catégorie")
                        .setNeutralButton("Ajouter", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setNegativeButton("Terminer", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        })
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (!spinner.getSelectedItem().toString().equalsIgnoreCase("Choisir")) {
                                    TaskCategory add = new TaskCategory(name.getText().toString(), spinner.getSelectedItem().toString());
                                    coach.list.add(coach.list.size(), add);
                                    TaskCategory category = new TaskCategory();
                                    //category = coach.list.get(coach.list.size() - 1);
                                    Toast.makeText(MainActivity.this,
                                            coach.list.get(coach.list.size() - 1) + " a été ajouté(e)",
                                            Toast.LENGTH_LONG).show();
                                }
                                else
                                    Toast.makeText(MainActivity.this, "Aucune catégorie ajoutée",
                                            Toast.LENGTH_LONG).show();
                            }
                        });
                builder.setView(view);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        Button button2 = findViewById(R.id.task_button);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                View view = getLayoutInflater().inflate(R.layout.enter_task, null);
                adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item,
                        getResources().getStringArray(R.array.journee));
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                name = view.findViewById(R.id.task_name);
                spinner = view.findViewById(R.id.spinner2);
                spinner.setAdapter(adapter);
                builder.setView(view)
                        .setTitle("Tâche")
                        .setNeutralButton("Ajouter", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setNegativeButton("Terminer", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        })
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (!spinner.getSelectedItem().toString().equalsIgnoreCase("Choisir")) {
                                    String task_name = name.getText().toString();
                                    Toast.makeText(MainActivity.this,
                                            spinner.getSelectedItem().toString(),
                                            Toast.LENGTH_LONG).show();
                                }
                            }
                        });
                builder.setView(view);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }
}
