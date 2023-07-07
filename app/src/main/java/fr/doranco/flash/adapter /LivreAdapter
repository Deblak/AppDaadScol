package fr.doranco.flash.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import fr.doranco.flash.R;
import fr.doranco.flash.entity.Livre;

public class LivreAdapter extends BaseAdapter {
    private List<Livre> mLivreList;
    private LayoutInflater mInflater;

    public LivreAdapter(List<Livre> listLivre, LayoutInflater inflater) {
        mLivreList = listLivre;
        mInflater = inflater;
    }

    @Override
    public int getCount() {
        return mLivreList.size();
    }

    @Override
    public Object getItem(int i) {
        return mLivreList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        final ViewItem item;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_livre, null);
            item= new ViewItem(convertView);
            convertView.setTag(item);
        } else{
            item = (ViewItem) convertView.getTag();
        }
        Livre curLivre = (Livre) getItem(i);

        item.titre.setText(curLivre.getTitre());
        item.prix.setText("Prix " + curLivre.getPrix());
        item.description.setText( curLivre.getDescription());
        item.image.setImageResource(R.drawable.msid);

        return convertView;
    }

    private class ViewItem {
        ImageView image;
        TextView titre;
        TextView prix;
        TextView description;

        public ViewItem(View view) {
            image = (ImageView) view.findViewById(R.id.image_view_livre);
            titre = (TextView) view.findViewById(R.id.titre_text_view);
            prix = (TextView) view.findViewById(R.id.prix_text_view);
            description = (TextView) view.findViewById(R.id.description_text_view);
        }
    }
}

