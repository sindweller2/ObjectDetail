package submission.objectdetail;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.GridViewHolder>{
    private Context context;
    private ArrayList<ObjectModel> listObject;

    public GridAdapter(Context context) {
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
    public GridAdapter.GridViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_grid, viewGroup, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridAdapter.GridViewHolder gridViewHolder, int i) {
        Glide.with(context)
                .load(getListObject().get(i).getPicture())
                .into(gridViewHolder.ivPicture);

        gridViewHolder.ivPicture.setOnClickListener(new CustomOnItemClickListener(i, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Intent intent = new Intent(context,DetailActivity.class);
                intent.putExtra(DetailActivity.name,getListObject().get(position).getName());
                intent.putExtra(DetailActivity.gender,getListObject().get(position).getGender());
                intent.putExtra(DetailActivity.picture,getListObject().get(position).getPicture());
                intent.putExtra(DetailActivity.remark,getListObject().get(position).getRemark());
                intent.putExtra(DetailActivity.status,getListObject().get(position).getStatus());
                intent.putExtra(DetailActivity.description,getListObject().get(position).getDescription());
                context.startActivity(intent);
            }
        }));
    }

    @Override
    public int getItemCount() {
        return getListObject().size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView ivPicture;
        GridViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            ivPicture = itemView.findViewById(R.id.iv_picture);

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
