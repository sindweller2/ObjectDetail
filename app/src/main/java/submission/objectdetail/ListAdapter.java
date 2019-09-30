package submission.objectdetail;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.CategoryViewHolder> {

    private Context context;
    private ArrayList<ObjectModel> listObject;

    public ListAdapter(Context context) {
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
    public ListAdapter.CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list, viewGroup, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.CategoryViewHolder categoryViewHolder, int i) {
        categoryViewHolder.tvName.setText(getListObject().get(i).getName());
        categoryViewHolder.tvRemark.setText(getListObject().get(i).getRemark());
        Glide.with(context)
                .load(getListObject().get(i).getPicture())
                .into(categoryViewHolder.ivPicture);

        categoryViewHolder.ivPicture.setOnClickListener(new CustomOnItemClickListener(i, new CustomOnItemClickListener.OnItemClickCallback() {
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

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvRemark;
        ImageView ivPicture;

        CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            tvName = itemView.findViewById(R.id.tv_name);
            tvRemark = itemView.findViewById(R.id.tv_remark);
            ivPicture = itemView.findViewById(R.id.civ_picture);

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
