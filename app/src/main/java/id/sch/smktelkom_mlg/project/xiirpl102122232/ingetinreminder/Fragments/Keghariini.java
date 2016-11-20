//package id.sch.smktelkom_mlg.project.xiirpl102122232.ingetinreminder.Fragments;
//
//import android.content.Context;
//import android.content.Intent;
//import android.net.Uri;
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v4.app.Fragment;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import id.sch.smktelkom_mlg.project.xiirpl102122232.ingetinreminder.DafkegRecycler;
//import id.sch.smktelkom_mlg.project.xiirpl102122232.ingetinreminder.R;
//
//public class Keghariini extends Fragment {
//    View v;
//    Context context;
//
//    public Keghariini() {
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
////        if (getArguments() != null) {
////            mParam1 = getArguments().getString(ARG_PARAM1);
////            mParam2 = getArguments().getString(ARG_PARAM2);
////        }
//    }
//
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//
//        v = inflater.inflate(R.layout.fragment_dafkeg, container, false);
//        context = v.getContext();
//        return v;
//    }
//
//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//
//        v.findViewById(R.id.senin).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(), DafkegRecycler.class);
//                startActivity(intent);
//            }
//        });
//
//        v.findViewById(R.id.selasa).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(), DafkegRecycler.class);
//                startActivity(intent);
//            }
//        });
//
//        v.findViewById(R.id.rabu).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(), DafkegRecycler.class);
//                startActivity(intent);
//            }
//        });
//
//        v.findViewById(R.id.kamis).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(), DafkegRecycler.class);
//                startActivity(intent);
//            }
//        });
//
//        v.findViewById(R.id.jumat).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(), DafkegRecycler.class);
//                startActivity(intent);
//            }
//        });
//
//        v.findViewById(R.id.sabtu).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(), DafkegRecycler.class);
//                startActivity(intent);
//            }
//        });
//
//        v.findViewById(R.id.minggu).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(), DafkegRecycler.class);
//                startActivity(intent);
//            }
//        });
//    }
//}
