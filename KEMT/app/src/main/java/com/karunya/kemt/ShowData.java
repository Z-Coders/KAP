package com.karunya.kemt;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import me.mvdw.recyclerviewmergeadapter.adapter.RecyclerViewMergeAdapter;







public class ShowData extends AppCompatActivity {
    RecyclerViewMergeAdapter mergeAdapter = new RecyclerViewMergeAdapter();
    RecyclerView recyclerView;
    RecyclerView recyclerView1;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference basRef;
    DatabaseReference oldbasRef;
    private FirebaseRecyclerAdapter<ShowDataItems, ShowDataViewHolder> mFirebaseAdapter;
    private FirebaseRecyclerAdapter<ShowDataItems, ShowDataViewHolder1> mFirebaseAdapter1;

    public ShowData() {

    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);
        firebaseDatabase = FirebaseDatabase.getInstance();

        basRef = FirebaseDatabase.getInstance().getReference("Live");
        oldbasRef = FirebaseDatabase.getInstance().getReference("BasketOld");


        recyclerView = (RecyclerView)findViewById(R.id.show_data_recycler_view);


        LinearLayoutManager layout =  new LinearLayoutManager(ShowData.this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layout);
        recyclerView.isNestedScrollingEnabled();



        Toast.makeText(ShowData.this, "Wait !  Fetching Data.", Toast.LENGTH_SHORT).show();


    }
    public void matches(View v){
        Intent i = new Intent(this,MatchesActivity.class);
        startActivity(i);

    }
    public void info(View v){
        Intent i = new Intent(this,InfoActivity.class);
        startActivity(i);

    }
    @Override
    public void onStart() {
        super.onStart();

        mFirebaseAdapter = new FirebaseRecyclerAdapter<ShowDataItems, ShowDataViewHolder>(ShowDataItems.class, R.layout.show_data_single_item, ShowDataViewHolder.class, basRef) {




            public void populateViewHolder(final ShowDataViewHolder viewHolder, ShowDataItems model, final int position) {
                viewHolder.Type(model.getType());
                viewHolder.Place(model.getPlace());
                viewHolder.Team1Score(model.getScore1());
                viewHolder.Team2Score(model.getScore2());
                viewHolder.TeamImage1(model.getTeam1Image());
                viewHolder.TeamImage2(model.getTeam2Image());
                viewHolder.TypeImage(model.getTypeImage());


                YoYo.with(Techniques.FadeInRight)
                        .duration(300)
                        .repeat(0)
                        .playOn(viewHolder.itemView);



                /*viewHolder.itemView.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(final View v) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(ShowData.this);
                        builder.setMessage("Do you want to Delete this data ?").setCancelable(false)
                                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        int selectedItems = position;
                                        mFirebaseAdapter.getRef(selectedItems).removeValue();
                                        mFirebaseAdapter.notifyItemRemoved(selectedItems);
                                        recyclerView.invalidate();
                                        onStart();
                                    }
                                })
                                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();
                                    }
                                });
                        AlertDialog dialog = builder.create();
                        dialog.setTitle("Confirm");
                        dialog.show();
                    }
                });*/


            }
        };


        recyclerView.setAdapter(mFirebaseAdapter);

        mFirebaseAdapter1 = new FirebaseRecyclerAdapter<ShowDataItems, ShowDataViewHolder1>(ShowDataItems.class, R.layout.show_data_single_item, ShowDataViewHolder1.class, oldbasRef) {




            public void populateViewHolder(final ShowDataViewHolder1 viewHolder, ShowDataItems model, final int position) {
                viewHolder.TypeImage(model.getTypeImage());
                viewHolder.Team1Score(model.getScore1());
                viewHolder.Team2Score(model.getScore2());
                viewHolder.TeamImage1(model.getTeam1Image());
                viewHolder.TeamImage2(model.getTeam2Image());


                YoYo.with(Techniques.FadeInRight)
                        .duration(300)
                        .repeat(0)
                        .playOn(viewHolder.itemView);



                /*viewHolder.itemView.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(final View v) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(ShowData.this);
                        builder.setMessage("Do you want to Delete this data ?").setCancelable(false)
                                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        int selectedItems = position;
                                        mFirebaseAdapter.getRef(selectedItems).removeValue();
                                        mFirebaseAdapter.notifyItemRemoved(selectedItems);
                                        recyclerView.invalidate();
                                        onStart();
                                    }
                                })
                                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();
                                    }
                                });
                        AlertDialog dialog = builder.create();
                        dialog.setTitle("Confirm");
                        dialog.show();
                    }
                });*/


            }
        };



    }



    public static class ShowDataViewHolder extends RecyclerView.ViewHolder {
        private final TextView Score1,Score2,location;
        private final ImageView image_url1;
        private final ImageView image_url2;
        private final ImageView icon;



        public ShowDataViewHolder(final View itemView) {
            super(itemView);

            image_url1 = (ImageView) itemView.findViewById(R.id.fetchImage1);
            image_url2 = (ImageView) itemView.findViewById(R.id.fetchImage2);
            icon = (ImageView) itemView.findViewById(R.id.iconCard);
            location = (TextView) itemView.findViewById(R.id.place);
            Score1 = (TextView) itemView.findViewById(R.id.Score1);
            Score2 = (TextView) itemView.findViewById(R.id.Score2);


        }
        private void Type(String title) {





        }
        private void Place(String title){

            location.setText(title);
        }
        private void Team1Score(String title) {


            Score1.setText(title);
        }
        private void Team2Score(String title) {






            Score2.setText(title);
        }

        private void TypeImage(String title) {

            /*Picasso.with(itemView.getContext())
                    .load(title)
                    .placeholder(R.drawable.loading)

                    .into(image_url);*/


            Glide.with(itemView.getContext())
                    .load(title)
                    .crossFade()


                    .placeholder(R.drawable.loading)

                    .into(icon);
        }
        private void TeamImage1(String title) {

            /*Picasso.with(itemView.getContext())
                    .load(title)
                    .placeholder(R.drawable.loading)

                    .into(image_url);*/


            Glide.with(itemView.getContext())
                    .load(title)
                    .crossFade()


                    .placeholder(R.drawable.loading)

                    .into(image_url1);
        }
        private void TeamImage2(String title) {

            /*Picasso.with(itemView.getContext())
                    .load(title)
                    .placeholder(R.drawable.loading)

                    .into(image_url);*/


            Glide.with(itemView.getContext())
                    .load(title)
                    .crossFade()


                    .placeholder(R.drawable.loading)

                    .into(image_url2);
        }



    }

    public static class ShowDataViewHolder1 extends RecyclerView.ViewHolder {
        private final TextView Score1,Score2,live,location;
        private final ImageView image_url1,icon;
        private final ImageView image_url2;



        public ShowDataViewHolder1(final View itemView) {
            super(itemView);
            location = (TextView) itemView.findViewById(R.id.place);
            image_url1 = (ImageView) itemView.findViewById(R.id.fetchImage1);
            image_url2 = (ImageView) itemView.findViewById(R.id.fetchImage2);
            icon = (ImageView) itemView.findViewById(R.id.iconCard);
            Score1 = (TextView) itemView.findViewById(R.id.Score1);
            Score2 = (TextView) itemView.findViewById(R.id.Score2);
            live = (TextView)itemView.findViewById(R.id.live);
            live.setVisibility(View.INVISIBLE);

        }


        private void Team1Score(String title) {


            Score1.setText(title);
        }
        private void Place(String title){

            location.setText(title);
        }

        private void Team2Score(String title) {






            Score2.setText(title);
        }
        private void TypeImage(String title) {

            /*Picasso.with(itemView.getContext())
                    .load(title)
                    .placeholder(R.drawable.loading)

                    .into(image_url);*/


            Glide.with(itemView.getContext())
                    .load(title)
                    .crossFade()


                    .placeholder(R.drawable.loading)

                    .into(icon);
        }

        private void TeamImage1(String title) {

            /*Picasso.with(itemView.getContext())
                    .load(title)
                    .placeholder(R.drawable.loading)

                    .into(image_url);*/


            Glide.with(itemView.getContext())
                    .load(title)
                    .crossFade()


                    .placeholder(R.drawable.loading)

                    .into(image_url1);
        }
        private void TeamImage2(String title){

            /*Picasso.with(itemView.getContext())
                    .load(title)
                    .placeholder(R.drawable.loading)

                    .into(image_url);*/


            Glide.with(itemView.getContext())
                    .load(title)
                    .crossFade()


                    .placeholder(R.drawable.loading)

                    .into(image_url2);
        }}

}
