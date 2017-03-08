package com.chenshun.learnsummarize.data;

import com.chenshun.learnsummarize.model.MultipleItemModel;
import com.chenshun.learnsummarize.model.SectionModel;
import com.chenshun.learnsummarize.model.StatusModel;
import com.chenshun.learnsummarize.model.VideoModel;

import java.util.ArrayList;
import java.util.List;

/**
 * User: chenshun <p />
 * Time: 17/3/7 16:53  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public class RecyclerviewData
{
    private static final String HTTPS_AVATARS1_GITHUBUSERCONTENT_COM_LINK = "https://avatars1.githubusercontent.com/u/7698209?v=3&s=460";
    private static final String CYM_CHAD = "CymChad";

    private RecyclerviewData()
    {
    }

    public static List<StatusModel> getSampleData(int lenth)
    {
        List<StatusModel> list = new ArrayList<>();
        for (int i = 0; i < lenth; i++)
        {
            StatusModel status = new StatusModel();
            status.setUserName("Chad" + i);
            status.setCreatedAt("04/05/" + i);
            status.setRetweet(i % 2 == 0);
            status.setUserAvatar("https://avatars1.githubusercontent.com/u/7698209?v=3&s=460");
            status.setText("BaseRecyclerViewAdpaterHelper https://www.recyclerview.org");
            list.add(status);
        }
        return list;
    }

    public static List<StatusModel> addData(List list, int dataSize)
    {
        for (int i = 0; i < dataSize; i++)
        {
            StatusModel status = new StatusModel();
            status.setUserName("Chad" + i);
            status.setCreatedAt("04/05/" + i);
            status.setRetweet(i % 2 == 0);
            status.setUserAvatar("https://avatars1.githubusercontent.com/u/7698209?v=3&s=460");
            status.setText("Powerful and flexible RecyclerAdapter https://github.com/CymChad/BaseRecyclerViewAdapterHelper");
            list.add(status);
        }
        return list;
    }

    public static List<SectionModel> getSampleData()
    {
        List<SectionModel> list = new ArrayList<>();
        list.add(new SectionModel(true, "Section 1", true));
        list.add(new SectionModel(new VideoModel(HTTPS_AVATARS1_GITHUBUSERCONTENT_COM_LINK, CYM_CHAD)));
        list.add(new SectionModel(new VideoModel(HTTPS_AVATARS1_GITHUBUSERCONTENT_COM_LINK, CYM_CHAD)));
        list.add(new SectionModel(new VideoModel(HTTPS_AVATARS1_GITHUBUSERCONTENT_COM_LINK, CYM_CHAD)));
        list.add(new SectionModel(new VideoModel(HTTPS_AVATARS1_GITHUBUSERCONTENT_COM_LINK, CYM_CHAD)));
        list.add(new SectionModel(true, "Section 2", false));
        list.add(new SectionModel(new VideoModel(HTTPS_AVATARS1_GITHUBUSERCONTENT_COM_LINK, CYM_CHAD)));
        list.add(new SectionModel(new VideoModel(HTTPS_AVATARS1_GITHUBUSERCONTENT_COM_LINK, CYM_CHAD)));
        list.add(new SectionModel(new VideoModel(HTTPS_AVATARS1_GITHUBUSERCONTENT_COM_LINK, CYM_CHAD)));
        list.add(new SectionModel(true, "Section 3", false));
        list.add(new SectionModel(new VideoModel(HTTPS_AVATARS1_GITHUBUSERCONTENT_COM_LINK, CYM_CHAD)));
        list.add(new SectionModel(new VideoModel(HTTPS_AVATARS1_GITHUBUSERCONTENT_COM_LINK, CYM_CHAD)));
        list.add(new SectionModel(true, "Section 4", false));
        list.add(new SectionModel(new VideoModel(HTTPS_AVATARS1_GITHUBUSERCONTENT_COM_LINK, CYM_CHAD)));
        list.add(new SectionModel(new VideoModel(HTTPS_AVATARS1_GITHUBUSERCONTENT_COM_LINK, CYM_CHAD)));
        list.add(new SectionModel(true, "Section 5", false));
        list.add(new SectionModel(new VideoModel(HTTPS_AVATARS1_GITHUBUSERCONTENT_COM_LINK, CYM_CHAD)));
        list.add(new SectionModel(new VideoModel(HTTPS_AVATARS1_GITHUBUSERCONTENT_COM_LINK, CYM_CHAD)));
        return list;
    }

    public static List<String> getStrData()
    {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++)
        {
            String str = HTTPS_AVATARS1_GITHUBUSERCONTENT_COM_LINK;
            if (i % 2 == 0)
            {
                str = CYM_CHAD;
            }
            list.add(str);
        }
        return list;
    }

    public static List<MultipleItemModel> getMultipleItemData()
    {
        List<MultipleItemModel> list = new ArrayList<>();
        for (int i = 0; i <= 4; i++)
        {
            list.add(new MultipleItemModel(MultipleItemModel.IMG, MultipleItemModel.IMG_SPAN_SIZE));
            list.add(new MultipleItemModel(MultipleItemModel.TEXT, MultipleItemModel.TEXT_SPAN_SIZE, CYM_CHAD));
            list.add(new MultipleItemModel(MultipleItemModel.IMG_TEXT, MultipleItemModel.IMG_TEXT_SPAN_SIZE));
            list.add(new MultipleItemModel(MultipleItemModel.IMG_TEXT, MultipleItemModel.IMG_TEXT_SPAN_SIZE_MIN));
            list.add(new MultipleItemModel(MultipleItemModel.IMG_TEXT, MultipleItemModel.IMG_TEXT_SPAN_SIZE_MIN));
        }
        return list;
    }
}
