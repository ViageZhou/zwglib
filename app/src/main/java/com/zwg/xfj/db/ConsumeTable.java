package com.zwg.xfj.db;


import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.zwg.xfj.utils.Logger;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.schedulers.Schedulers;


/**
 * Created by ZhouWengong on 2023/3/29.
 */
public class ConsumeTable implements com.zwg.xfj.db.IBaseTable {

    public static final String TAG = ConsumeTable.class.getSimpleName();
    private static final String TABLE_NAME = "consume_record";
    private static final String COLUMN_CONSUME_ID = "consume_id";
    private static final String COLUMN_CARD_ID = "card_id";
    private static final String COLUMN_DEVICE_SN = "device_sn";
    private static final String COLUMN_MONEY = "money";
    private static final String COLUMN_TIME = "time";
    private static final String COLUMN_UPLOAD = "upload";

    private final com.zwg.xfj.db.DBHelper mHelper;

    public ConsumeTable(com.zwg.xfj.db.DBHelper helper) {
        this.mHelper = helper;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists " + TABLE_NAME + "(" +
                COLUMN_CONSUME_ID + " text," +
                COLUMN_CARD_ID + " text," +
                COLUMN_DEVICE_SN + " text," +
                COLUMN_MONEY + " text," +
                COLUMN_TIME + " text," +
                COLUMN_UPLOAD + " integer" +
                ")");
    }

//    public void insert(CardInfoBean bean) {
//        ThreadPool.execute(() -> {
//            ContentValues values = new ContentValues();
//            values.put(COLUMN_CONSUME_ID, bean.getConsumeID());
//            values.put(COLUMN_CARD_ID, bean.getCardID());
//            values.put(COLUMN_DEVICE_SN, bean.getDeviceSN());
//            values.put(COLUMN_MONEY, bean.getMoney());
//            values.put(COLUMN_TIME, bean.getTradeTime());
//            values.put(COLUMN_UPLOAD, 0);
//            mHelper.getReadableDatabase().insert(TABLE_NAME, null, values);
//        });
//    }
//
//    public Observable<List<CardInfoBean>> getRecordList() {
//        return Observable.create((ObservableOnSubscribe<List<CardInfoBean>>) emitter -> {
//            List<CardInfoBean> ret = new ArrayList<>();
//            try (Cursor cursor = mHelper.getReadableDatabase().query(TABLE_NAME, null,
//                    COLUMN_UPLOAD + " = ?", new String[]{"0"}, null, null, null)) {
//                while (cursor.moveToNext()) {
//                    int columnIndex = cursor.getColumnIndex(COLUMN_CONSUME_ID);
//                    if (columnIndex < 0) {
//                        continue;
//                    }
//                    String consumeID = cursor.getString(columnIndex);
//                    String consumeID_10 = CommandHelper.insertStrLength(Long.parseLong(consumeID, 16) + "", 10);
//
//                    columnIndex = cursor.getColumnIndex(COLUMN_CARD_ID);
//                    if (columnIndex < 0) {
//                        continue;
//                    }
//                    String cardID = cursor.getString(columnIndex);
//
//                    columnIndex = cursor.getColumnIndex(COLUMN_DEVICE_SN);
//                    if (columnIndex < 0) {
//                        continue;
//                    }
//                    String sn = cursor.getString(columnIndex);
//
//                    columnIndex = cursor.getColumnIndex(COLUMN_MONEY);
//                    if (columnIndex < 0) {
//                        continue;
//                    }
//                    String money = cursor.getString(columnIndex);
//
//                    columnIndex = cursor.getColumnIndex(COLUMN_TIME);
//                    if (columnIndex < 0) {
//                        continue;
//                    }
//                    String time = cursor.getString(columnIndex);
//
//                    CardInfoBean bean = new CardInfoBean();
//                    bean.setCardID(cardID);
//                    bean.setConsumeID(consumeID);
//                    bean.setConsumeID_10(consumeID_10);
//                    bean.setMoney(money);
//                    bean.setTradeTime(time);
//                    bean.setDeviceSN(sn);
//
//                    ret.add(bean);
//                }
//            } catch (Exception e) {
//                Logger.e(TAG, "[getRecordList]Error: ", e);
//            }
//            emitter.onNext(ret);
//        }).subscribeOn(Schedulers.io()).observeOn(Schedulers.io());
//    }
//
//    public Observable<Boolean> updateUploadStatus(List<CardInfoBean> beanList) {
//        return Observable.create((ObservableOnSubscribe<Boolean>) emitter -> {
//            for (CardInfoBean bean : beanList) {
//                ContentValues values = new ContentValues();
//                values.put(COLUMN_UPLOAD, 1);
//                mHelper.getReadableDatabase().update(TABLE_NAME, values,
//                        COLUMN_CONSUME_ID + " = ? ", new String[]{bean.getConsumeID()});
//            }
//            emitter.onNext(true);
//        }).subscribeOn(Schedulers.io()).observeOn(Schedulers.io());
//    }

//    public void getCurrentUserChatList(String currentUserID, OnDataReady onDataReady) {
//        ThreadPool.getInstance().getExecutorService().execute(() -> {
//            List<ChatItem> list = new ArrayList<>();
//            Cursor cursor = mHelper.getReadableDatabase().query(TABLE_NAME, null, COLUMN_FRIEND_ID + " = ?", new String[]{currentUserID}, null, null, COLUMN_LAST_CHAT_DATE + " desc");
//            while (cursor.moveToNext()) {
//                int columnIndex = cursor.getColumnIndex(COLUMN_CHAT_ID);
//                if (columnIndex < 0) {
//                    Log.e(TAG, "selectAll: columnIndex < 0 -- COLUMN_CHAT_ID");
//                    return;
//                }
//                String chatID = cursor.getString(columnIndex);
//                List<Friend> friendList = new ArrayList<>();
//
//                //查看当前会话还包含哪些用户
//                Cursor cursorChatList = mHelper.getReadableDatabase().query(TABLE_NAME, null, COLUMN_CHAT_ID + " = ?", new String[]{chatID}, null, null, null);
//                out:
//                while (cursorChatList.moveToNext()) {
//                    columnIndex = cursorChatList.getColumnIndex(COLUMN_FRIEND_ID);
//                    if (columnIndex < 0) {
//                        cursorChatList.close();
//                        return;
//                    }
//                    String string = cursorChatList.getString(columnIndex);
//                    if (string.equals(currentUserID)) {
//                        continue out;
//                    }
//                    for (Friend friend : friendList) {
//                        if (string.equals(friend.getFriendID())) {
//                            continue out;
//                        }
//                    }
//
//                    Friend friend = new Friend();
//                    friend.setFriendID(string);
//
//                    columnIndex = cursorChatList.getColumnIndex(COLUMN_FRIEND_NAME);
//                    if (columnIndex < 0) {
//                        Log.e(TAG, "selectAll: columnIndex < 0 -- COLUMN_FRIEND_NAME");
//                        return;
//                    }
//                    friend.setFriendName(cursorChatList.getString(columnIndex));
//                    friendList.add(friend);
//                }
//                cursorChatList.close();
//
//                ChatItem item = new ChatItem();
//                item.setChatID(chatID);
//                item.setFriendList(friendList);
//
//                columnIndex = cursor.getColumnIndex(COLUMN_CHAT_TYPE);
//                if (columnIndex < 0) {
//                    Log.e(TAG, "selectAll: columnIndex < 0 -- COLUMN_CHAT_TYPE");
//                    return;
//                }
//                item.setChatType(cursor.getString(columnIndex));
//
//
//                if (item.getChatType().equals(ChatFragment.CHAT_TYPE_SINGLE)) {
//
//                    List<Friend> list1 = item.getFriendList();
//                    if (list1.size() != 0) {
//                        Friend friend = list1.get(0);
//                        item.setFriendID(friend.getFriendID());
//                        item.setFriendName(friend.getFriendName());
//                    }
//
//
//                } else {
//
//
//                }
//
//                list.add(item);
//
//            }
//            cursor.close();
//
//            for (ChatItem chatItem : list) {
//                MsgItem lastMsg = DBHelper.getInstance().getMassageTable().getLastMassageByChatID(chatItem.getChatID());
//                if (lastMsg == null) {
//                    continue;
//                }
//                chatItem.setLastContent(lastMsg.getMsg());
//                chatItem.setLastContentOwner(lastMsg.getMsgOwnerName());
//                chatItem.setLastChatDate(lastMsg.getTime());
//                chatItem.setStrLastChatDate(lastMsg.getSendTime());
//
//                ContentValues values = new ContentValues();
//                values.put(COLUMN_LAST_CONTENT, chatItem.getLastContent());
//                values.put(COLUMN_LAST_CONTENT_OWNER, chatItem.getLastContentOwner());
//                values.put(COLUMN_LAST_CHAT_DATE, chatItem.getLastChatDate());
//                mHelper.getReadableDatabase().update(TABLE_NAME, values, COLUMN_CHAT_ID + " = ? ", new String[]{chatItem.getChatID()});
//            }
//
//            onDataReady.onReceive(list);
//        });
//    }
//
//    public void getFriendsInSameChat(String chatID, OnDataReady onDataReady) {
//        ThreadPool.getInstance().getExecutorService().execute(() -> {
//            List<Friend> list = new ArrayList<>();
//            ChatItem item = new ChatItem();
//            item.setFriendList(list);
//            Cursor cursor = mHelper.getReadableDatabase().query(TABLE_NAME, null, COLUMN_CHAT_ID + " = ?", new String[]{chatID}, null, null, COLUMN_LAST_CHAT_DATE + " desc");
//            while (cursor.moveToNext()) {
//                Friend friend = new Friend();
//
//                int columnIndex = cursor.getColumnIndex(COLUMN_CHAT_ID);
//                if (columnIndex < 0) {
//                    Log.e(TAG, "selectAll: columnIndex < 0 -- setChatID");
//                    return;
//                }
//                item.setChatID(cursor.getString(columnIndex));
//
//                columnIndex = cursor.getColumnIndex(COLUMN_FRIEND_ID);
//                if (columnIndex < 0) {
//                    Log.e(TAG, "selectAll: columnIndex < 0 -- setFriendID");
//                    return;
//                }
//                friend.setFriendID(cursor.getString(columnIndex));
//
//                columnIndex = cursor.getColumnIndex(COLUMN_FRIEND_NAME);
//                if (columnIndex < 0) {
//                    Log.e(TAG, "selectAll: columnIndex < 0 -- setFriendName");
//                    return;
//                }
//                friend.setFriendName(cursor.getString(columnIndex));
//
//                columnIndex = cursor.getColumnIndex(COLUMN_CHAT_TYPE);
//                if (columnIndex < 0) {
//                    Log.e(TAG, "selectAll: columnIndex < 0 -- setChatType");
//                    return;
//                }
//                item.setChatType(cursor.getString(columnIndex));
//
//                list.add(friend);
//
//            }
//            cursor.close();
//            onDataReady.onReceive(item);
//        });
//    }
//
//    public void getSingleChatIfExist(String friendID, OnDataReady onDataReady) {
//        ThreadPool.getInstance().getExecutorService().execute(() -> {
//            List<ChatItem> list = new ArrayList<>();
//            Cursor cursor = mHelper.getReadableDatabase().query(TABLE_NAME, null, COLUMN_CHAT_TYPE + " = ? and " + COLUMN_FRIEND_ID + " = ? ",
//                    new String[]{ChatFragment.CHAT_TYPE_SINGLE, friendID}, null, null, null);
//            while (cursor.moveToNext()) {
//                ChatItem item = new ChatItem();
//
//                int columnIndex = cursor.getColumnIndex(COLUMN_CHAT_ID);
//                if (columnIndex < 0) {
//                    Log.e(TAG, "selectAll: columnIndex < 0 -- setChatID");
//                    return;
//                }
//                item.setChatID(cursor.getString(columnIndex));
//
//
//
//                columnIndex = cursor.getColumnIndex(COLUMN_FRIEND_ID);
//                if (columnIndex < 0) {
//                    Log.e(TAG, "selectAll: columnIndex < 0 -- setFriendID");
//                    return;
//                }
//                item.setFriendID(cursor.getString(columnIndex));
//
//                columnIndex = cursor.getColumnIndex(COLUMN_FRIEND_NAME);
//                if (columnIndex < 0) {
//                    Log.e(TAG, "selectAll: columnIndex < 0 -- setFriendName");
//                    return;
//                }
//                item.setFriendName(cursor.getString(columnIndex));
//
//                columnIndex = cursor.getColumnIndex(COLUMN_CHAT_TYPE);
//                if (columnIndex < 0) {
//                    Log.e(TAG, "selectAll: columnIndex < 0 -- setChatType");
//                    return;
//                }
//                item.setChatType(cursor.getString(columnIndex));
//
//                columnIndex = cursor.getColumnIndex(COLUMN_LAST_CONTENT);
//                if (columnIndex < 0) {
//                    Log.e(TAG, "selectAll: columnIndex < 0 -- setLastContent");
//                    return;
//                }
//                item.setLastContent(cursor.getString(columnIndex));
//
//                columnIndex = cursor.getColumnIndex(COLUMN_LAST_CONTENT_OWNER);
//                if (columnIndex < 0) {
//                    Log.e(TAG, "selectAll: columnIndex < 0 -- setLastContentOwner");
//                    return;
//                }
//                item.setLastContentOwner(cursor.getString(columnIndex));
//
//                columnIndex = cursor.getColumnIndex(COLUMN_LAST_CHAT_DATE);
//                if (columnIndex < 0) {
//                    Log.e(TAG, "selectAll: columnIndex < 0 -- setStrLastChatDate");
//                    return;
//                }
//                item.setStrLastChatDate(cursor.getString(columnIndex));
//
//
//
//
//                list.add(item);
//
//            }
//            cursor.close();
//            onDataReady.onReceive(list);
//        });
//    }
//
//
//    public void getAllFriendInChatList(OnDataReady onDataReady) {
//        ThreadPool.getInstance().getExecutorService().execute(() -> {
//            SQLiteDatabase db = mHelper.getReadableDatabase();
//
//            List<ChatItem> localChatItems = new ArrayList<>();
//            Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, null);
//            first:
//            while (cursor.moveToNext()) {
//                int columnIndex = cursor.getColumnIndex(COLUMN_FRIEND_ID);
//                if (columnIndex < 0) {
//                    cursor.close();
//                    return;
//                }
//                String friendID = cursor.getString(columnIndex);
//
//                for (ChatItem localChatItem : localChatItems) {
//                    if (friendID.equals(localChatItem.getFriendID())) {
//                        continue first;
//                    }
//                }
//
//                ChatItem item = new ChatItem();
//
//                columnIndex = cursor.getColumnIndex(COLUMN_CHAT_ID);
//                if (columnIndex < 0) {
//                    Log.e(TAG, "insert: columnIndex < 0 COLUMN_UNIQUE_ID");
//                    return;
//                }
//                String chatID = cursor.getString(columnIndex);
//
//                item.setChatID(chatID);
//                item.setFriendID(friendID);
//
//                localChatItems.add(item);
//
//            }
//            cursor.close();
//
//            onDataReady.onReceive(localChatItems);
//
//
//        });
//    }


}
