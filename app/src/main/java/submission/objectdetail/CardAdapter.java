package submission.objectdetail;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardViewViewHolder>{
    private Context context;
    private ArrayList<ObjectModel> listObject;

    public CardAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<ObjectModel> getListObject() {
        return listObject;
    }

    public void setListObject(ArrayList<ObjectModel> listObject) {
        this.listObject = listObject;
    }

    @NonNull
    @Override
    public CardAdapter.CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_card, viewGroup, false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardAdapter.CardViewViewHolder cardViewViewHolder, int i) {

        ObjectModel objectModel = getListObject().get(i);

        Glide.with(context)
                .load(objectModel.getPicture())
                .into(cardViewViewHolder.ivPicture);

        cardViewViewHolder.tvName.setText(objectModel.getName());
        
        cardViewViewHolder.tvRemark.setText(objectModel.getRemark());

        cardViewViewHolder.bFavorite.setOnClickListener(new CustomOnItemClickListener(i, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(context, "Favorite "+ getListObject().get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        }));

        cardViewViewHolder.bShare.setOnClickListener(new CustomOnItemClickListener(i, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(context, "Share "+getListObject().get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        }));
    }

    @Override
    public int getItemCount() {
        return getListObject().size();
    }

    public class CardViewViewHolder  extends RecyclerView.ViewHolder {
        ImageView ivPicture;
        TextView tvName, tvRemark;
        Button bFavorite, bShare;

        CardViewViewHolder(final View itemView) {
            super(itemView);
            context = itemView.getContext();
            ivPicture = itemView.findViewById(R.id.iv_picture);
            tvName = itemView.findViewById(R.id.tv_name);
            tvRemark = itemView.findViewById(R.id.tv_remark);
            bFavorite = itemView.findViewById(R.id.b_favorite);
            bShare = itemView.findViewById(R.id.b_share);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context,DetailActivity.class);
                    intent.putExtra(DetailActivity.name,getListObject().get(getAdapterPosition()).getName());
                    intent.putExtra(DetailActivity.gender,getListObject().get(getAdapterPosition()).getGender());
                    intent.putExtra(DetailActivity.picture,getListObject().get(getAdapterPosition()).getPicture());
                    intent.putExtra(DetailActivity.remark,getListObject().get(getAdapterPosition()).getRemark());
                    intent.putExtra(DetailActivity.status,getListObject().get(getAdapterPosition()).getStatus());
                    intent.putExtra(DetailActivity.description,getListObject().get(getAdapterPosition()).getDescription());
                    context.startActivity(intent);
                }
            });
        }
    }
}
