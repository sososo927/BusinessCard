<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="model.CustomerBean,model.UserBean" %>
<%
UserBean loginUser=(UserBean)session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>名刺検索画面</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css">
    <link rel="stylesheet" href="css/style.css"> <!-- カスタムスタイルがあれば追加 -->
</head>
<body class="bg-gray-100">
<a class="mypage bg-blue-500 text-white p-2 rounded" href="Main?action=main&pr=<%= loginUser.getLoginid() %>">マイページへ</a>

<form action="/BusinessCard_School/CardSearch" method="post" class="my-4 p-4 bg-white shadow-md rounded-md">
    <div class="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-4">
        <!-- 県の選択 -->
        <div class="mb-4">
            <label for="Prefecture" class="block text-sm font-medium leading-6 text-gray-900 mb-2">県</label>
            <select name="Prefecture" id="Prefecture" class="form-input">
                <option value="">未選択</option>
                <!-- 47都道府県のオプションを省略せずに出力 -->
                <%
                    String[] prefectures = {"北海道","青森県","岩手県","宮城県","秋田県","山形県","福島県",
                                           "茨城県","栃木県","群馬県","埼玉県","千葉県","東京都","神奈川県",
                                           "新潟県","富山県","石川県","福井県","山梨県","長野県","岐阜県",
                                           "静岡県","愛知県","三重県","滋賀県","京都府","大阪府","兵庫県",
                                           "奈良県","和歌山県","鳥取県","島根県","岡山県","広島県","山口県",
                                           "徳島県","香川県","愛媛県","高知県","福岡県","佐賀県","長崎県",
                                           "熊本県","大分県","宮崎県","鹿児島県","沖縄県"};
                    for (String prefecture : prefectures) {
                %>
                    <option value="<%=prefecture %>"><%=prefecture %></option>
                <%
                    }
                %>
            </select>
        </div>

        <!-- 業種の選択 -->
        <div class="mb-4">
            <label for="Industry" class="block text-sm font-medium leading-6 text-gray-900 mb-2">業種</label>
            <select name="Industry" id="Industry" class="form-input">
                <option value="">未選択</option>
                <!-- 業種のオプションを省略せずに出力 -->
                <%
                    String[] industries = {"ITエンジニア","webデザイナー","youtuber","アイドル","アイリスト",
                                           "アクチュアリー","アナウンサー","アニメーター","アフィリエイター","アロマセラピスト",
                                           "医師","板前","イベント企画者","イベントコンパニオン","医療事務",
                                           "医療情報管理士","医療秘書","翻訳家","宇宙飛行士","映画監督",
                                           "占い師","映画バイヤー","営業職","栄養士","外交官","外国語講師",
                                           "外務公務員","海上保安官","カスタマーエンジニア","家庭教師","看護師",
                                           "気象予報士","客室乗務員","教員","金融ディーラー","グランドスタッフ",
                                           "警察官","警備員","刑務官","校正者","国税専門官","国家公務員",
                                           "コメディアン","経理スタッフ","経営コンサルタント","建築士","現場監督",
                                           "ゲームクリエイター","工場勤務","公務員","コスプレイヤー","子役",
                                           "作業療法士","作家","サックスプレイヤー","自衛官","児童英語教師",
                                           "事務職員","証券アナリスト","助産師","消防官","診療放射線技師",
                                           "スポーツ審判員","清掃員","税理士","セキュリティエンジニア","設計士",
                                           "電気工事士","地方公務員","通訳","通訳ガイド","ディスプレイデザイナー",
                                           "図書館司書","トランぺッター","日本語教師","ニュースキャスター","俳優",
                                           "ファッションデザイナー","ファイナンシャルプランナー","ファンドマネージャー",
                                           "秘書","美容士","プログラマー","保育士","法務教官","保健師",
                                           "翻訳家","マニピュレーター","麻薬取締官","ミュージカル俳優","レスキュー隊員",
                                           "薬剤師","労働基準監督署","ローデイー","レンタル彼氏、彼女","レセプショニスト",
                                           "レースクイーン","臨床心理士","臨床工学技士","臨床検査モニター","臨床検査技師",
                                           "料理研究家","漁師","理容師","リポーター","リフレクソロジスト","理学療法士",
                                           "ラッパー","ラジオＤＪ","落語家","ライター","レーサー","録音技師",
                                           "和裁士","和紙職人","和菓子職人"};
                    for (String industry : industries) {
                %>
                    <option value="<%=industry %>"><%=industry %></option>
                <%
                    }
                %>
            </select>
        </div>

        <!-- 氏名の入力 -->
        <div class="mb-4">
            <label for="name" class="block text-sm font-medium leading-6 text-gray-900 mb-2">氏名</label>
            <input type="text" name="name" id="name" placeholder="氏名" class="form-input">
        </div>

        <!-- 会社名の入力 -->
        <div class="mb-4">
            <label for="companyname" class="block text-sm font-medium leading-6 text-gray-900 mb-2">会社名</label>
            <input type="text" name="companyname" id="companyname" placeholder="会社名" class="form-input">
        </div>
    </div>

    <!-- 検索ボタン -->
   <div class="col-span-3">
        <input type="submit" value="検索" class="bg-blue-500 text-white p-2 rounded cursor-pointer">
    </div>
</form>

<%
    ArrayList<CustomerBean> cardDatalist = (ArrayList<CustomerBean>)request.getAttribute("user_list");

    if (cardDatalist == null || cardDatalist.size() == 0){
%>
    <div class="businessCard bg-white p-4 my-4 shadow-md rounded-md">
        <p class="text-lg font-semibold">検索結果</p>
        <p class="text-gray-500">なし</p>
    </div>
<%  } else { %>
    <% for(int i = 0; i < cardDatalist.size(); i++){ %>
        <form method="post" name="form<%=i %>" action="/BusinessCard_School/CardSearch?action=<%= cardDatalist.get(i).getAID() %>">
            <input type="hidden" name=<%= cardDatalist.get(i).getAID() %> value="名前">
            <a href="javascript:form<%=i %>.submit()">
                <div class="businessCard bg-white p-4 my-4 shadow-md rounded-md">
                    <p>ID<%= cardDatalist.get(i).getAID() %></p>
                    <p><%= cardDatalist.get(i).getIndustry() %></p>
                    <p><%= cardDatalist.get(i).getFN() %></p>
                    <p><%= cardDatalist.get(i).getCname() %></p>
                    <p><%= cardDatalist.get(i).getPhonenum() %></p>
                    <p><%= cardDatalist.get(i).getGender() %></p>
                    <p><%= cardDatalist.get(i).getPrefecture() %></p>
                    <p><%= cardDatalist.get(i).getAddress() %></p>
                    <p><%= cardDatalist.get(i).getMailAdd() %></p>
                </div>
            </a>
        </form>
    <% } %>
<% } %>

</body>
</html>
