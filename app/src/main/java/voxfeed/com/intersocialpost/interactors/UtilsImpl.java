package voxfeed.com.intersocialpost.interactors;

import android.graphics.Color;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import voxfeed.com.intersocialpost.R;
import voxfeed.com.intersocialpost.model.Stats;
import voxfeed.com.intersocialpost.model.StatsItem;
import voxfeed.com.intersocialpost.presenters.PostActivityPresenter;

/**
 * Created by Rafael Jasso on 2/4/17.
 */

public class UtilsImpl implements Utils {
    public static final String FACEBOOK = "facebook";
    public static final String TWITTER = "twitter";
    public static final String INSTAGRAM = "instagram";

    public static final String FACEBOOK_RGB = "#45609C";
    public static final String TWITTER_RGB = "#1DA1F2";
    public static final String INSTAGRAM_RGB = "#E4405F";

    private static final String VER_PUBLICACION = "VER PUBLICACIÓN EN ";

    private static final String[] mMeses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};


    @Override
    public String calcDate(String dateStr) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date d = null;
        try {
            d = formatter.parse(dateStr.substring(0,10));
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }

        Calendar calDate = Calendar.getInstance();
        calDate.setTime(d);

        int day = calDate.get(Calendar.DAY_OF_MONTH);
        String month = mMeses[calDate.get(Calendar.MONTH)];
        String formatDate =  day + " " + month;

        return formatDate;
    }

    @Override
    public int getColor(String social) {
        String color = null;

        switch (social) {
            case FACEBOOK:
                color = FACEBOOK_RGB;
                break;
            case TWITTER:
                color = TWITTER_RGB;
                break;
            case INSTAGRAM:
                color = INSTAGRAM_RGB;
                break;
        }

        return Color.parseColor(color);
    }

    @Override
    public void getStats(Stats stats, PostActivityPresenter presenter) {
        List<StatsItem> statsItems = new ArrayList<>();
        statsItems.add(new StatsItem(R.mipmap.icon_likes, "Me gusta", stats.getLikes()));
        statsItems.add(new StatsItem(R.mipmap.icon_clicks, "Clics", stats.getClicks()));
        statsItems.add(new StatsItem(R.mipmap.icon_comments, "Comentarios", stats.getComments()));
        statsItems.add(new StatsItem(R.mipmap.icon_share, "Compartido", stats.getShares()));
        statsItems.add(new StatsItem(R.mipmap.icon_reach, "Alcance", stats.getAudience()));

        presenter.setAdapter(statsItems);
    }

    @Override
    public String getVerPublicacionMessage(String social) {
        return VER_PUBLICACION + social.toUpperCase();
    }


}
