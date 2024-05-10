<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

  <head>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <script src="https://cdn.tailwindcss.com"></script>
      <script src="https://ajaxzip3.github.io/ajaxzip3.js" charset="UTF-8"></script>
  </head>
  <div class="flex min-h-full flex-col justify-center px-6 py-12 lg:px-8">
    <div class="sm:mx-auto sm:w-full sm:max-w-sm">
      <img class="mx-auto h-10 w-auto" src="https://tailwindui.com/img/logos/mark.svg?color=indigo&shade=600" alt="Your Company">
      <h2 class="mt-10 text-center text-2xl font-bold leading-9 tracking-tight text-gray-900">アカウント登録</h2>
    </div>
  
    <div class="mt-10 sm:mx-auto sm:w-full sm:max-w-sm">
      <form class="space-y-6" action="Main" method="post">
        <!-- <div>
            <label for="AID" class="block text-sm font-medium leading-6 text-gray-900">id</label>
            <div class="mt-2">
              <input id="AID" name="AID" type="AID" autocomplete="AID" required class="block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 sm:text-sm sm:leading-6">
            </div>
          </div> -->
          <div>
            <div class="flex items-center justify-between">
              <label for="Pass" class="block text-sm font-medium leading-6 text-gray-900">パスワード</label>
            </div>
            <div class="mt-2">
              <input id="Pass" name="Pass" type="password" autocomplete="current-password" required class="block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 sm:text-sm sm:leading-6">
            </div>
          </div>
       
        <div>
	       	<label for="Industry" class="block text-sm font-medium leading-6 text-gray-900">業種</label>
			    <select name="Industry">
				<option value="ITエンジニア">ITエンジニア</option>
				<option value="webデザイナー">webデザイナー</option>
				<option value="youtuber">YouTuber</option>
				<option value="アイドル">アイドル</option>
				<option value="アイリスト">アイリスト</option>
				<option value="アクチュアリー">アクチュアリー</option>
				<option value="アナウンサー">アナウンサー</option>
				<option value="アニメーター">アニメーター</option>
				<option value="アフィリエイター">アフィリエイター</option>
				<option value="アロマセラピスト">アロマセラピスト</option>
				<option value="医師">医師</option>
				<option value="板前">板前</option>
				<option value="イベント企画者">イベント企画者</option>
				<option value="イベントコンパニオン">イベントコンパニオン</option>
				<option value="医療事務">医療事務</option>
				<option value="医療情報管理士">医療情報管理士</option>
				<option value="医療秘書">医療秘書</option>
				<option value="翻訳家">翻訳家</option>
				<option value="宇宙飛行士">宇宙飛行士</option>
				<option value="映画監督">映画監督</option>
				<option value="占い師">占い師</option>
				<option value="映画バイヤー">映画バイヤー</option>
				<option value="営業職">営業職</option>
				<option value="栄養士">栄養士</option>
				<option value="外交官">外交官</option>
				<option value="外国語講師">外国語講師</option>
				<option value="外務公務員">外務公務員</option>
				<option value="海上保安官">海上保安官</option>
				<option value="カスタマーエンジニア">カスタマーエンジニア</option>
				<option value="家庭教師">家庭教師</option>
				<option value="看護師">看護師</option>
				<option value="気象予報士">気象予報士</option>
				<option value="客室乗務員">客室乗務員</option>
				<option value="教員">教員</option>
				<option value="金融ディーラー">金融ディーラー</option>
				<option value="グランドスタッフ">グランドスタッフ</option>
				<option value="警察官">警察官</option>
				<option value="警備員">警備員</option>
				<option value="刑務官">刑務官</option>
				<option value="校正者">校正者</option>
				<option value="国税専門官">国税専門官</option>
				<option value="国家公務員">国家公務員</option>
				<option value="コメディアン">コメディアン</option>
				<option value="経理スタッフ">経理スタッフ</option>
				<option value="経営コンサルタント">経営コンサルタント</option>
				<option value="建築士">建築士</option>
				<option value="現場監督">現場監督</option>
				<option value="ゲームクリエイター">ゲームクリエイター</option>
				<option value="工場勤務">工場勤務</option>
				<option value="公務員">公務員</option>
				<option value="コスプレイヤー">コスプレイヤー</option>
				<option value="子役">子役</option>
				<option value="作業療法士">作業療法士</option>
				<option value="作家">作家</option>
				<option value="サックスプレイヤー">サックスプレイヤー</option>
				<option value="自衛官">自衛官</option>
				<option value="児童英語教師">児童英語教師</option>
				<option value="事務職員">事務職員</option>
				<option value="証券アナリスト">証券アナリスト</option>
				<option value="助産師">助産師</option>
				<option value="消防官">消防官</option>
				<option value="診療放射線技師">診療放射線技師</option>
				<option value="スポーツ審判員">スポーツ審判員</option>
				<option value="清掃員">清掃員</option>
				<option value="税理士">税理士</option>
				<option value="セキュリティエンジニア">セキュリティエンジニア</option>
				<option value="設計士">設計士</option>
				<option value="電気工事士">電気工事士</option>
				<option value="地方公務員">地方公務員</option>
				<option value="通訳">通訳</option>
				<option value="通訳ガイド">通訳ガイド</option>
				<option value="ディスプレイデザイナー">ディスプレイデザイナー</option>
				<option value="図書館司書">図書館司書</option>
				<option value="トランぺッター">トランぺッター</option>
				<option value="日本語教師">日本語教師</option>
				<option value="ニュースキャスター">ニュースキャスター</option>
				<option value="俳優">俳優</option>
				<option value="ファッションデザイナー">ファッションデザイナー</option>
				<option value="ファイナンシャルプランナー">ファイナンシャルプランナー</option>
				<option value="ファンドマネージャー">ファンドマネージャー</option>
				<option value="秘書">秘書</option>
				<option value="美容士">美容士</option>
				<option value="プログラマー">プログラマー</option>
				<option value="保育士">保育士</option>
				<option value="法務教官">法務教官</option>
				<option value="保健師">保健師</option>
				<option value="翻訳家">翻訳家</option>
				<option value="マニピュレーター">マニピュレーター</option>
				<option value="麻薬取締官">麻薬取締官</option>
				<option value="ミュージカル俳優">ミュージカル俳優</option>
				<option value="レスキュー隊員">レスキュー隊員</option>
				<option value="薬剤師">薬剤師</option>
				<option value="労働基準監督署">労働基準監督署</option>
				<option value="ローデイー">ローデイー</option>
				<option value="レンタル彼氏、彼女">レンタル彼氏、彼女</option>
				<option value="レセプショニスト">レセプショニスト</option>
				<option value="レースクイーン">レースクイーン</option>
				<option value="臨床心理士">臨床心理士</option>
				<option value="臨床工学技士">臨床工学技士</option>
				<option value="臨床検査モニター">臨床検査モニター</option>
				<option value="臨床検査技師">臨床検査技師</option>
				<option value="料理研究家">料理研究家</option>
				<option value="漁師">漁師</option>
				<option value="理容師">理容師</option>
				<option value="リポーター">リポーター</option>
				<option value="リフレクソロジスト">リフレクソロジスト</option>
				<option value="理学療法士">理学療法士</option>
				<option value="ラッパー">ラッパー</option>
				<option value="ラジオＤＪ">ラジオＤＪ</option>
				<option value="落語家">落語家</option>
				<option value="ライター">ライター</option>
				<option value="レーサー">レーサー</option>
				<option value="録音技師">録音技師</option>
				<option value="和裁士">和裁士</option>
				<option value="和紙職人">和紙職人</option>
				<option value="和菓子職人">和菓子職人</option>


				</select>
		</div>
        <div>
          <label for="Phonenum" class="block text-sm font-medium leading-6 text-gray-900">電話番号</label>
          <div class="mt-2">
            <input id="Phonenum" name="Phonenum" type="Phonenum" autocomplete="Phonenum" required class="block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400  sm:text-sm sm:leading-6">
          </div>
        </div>

        <div>
          <label for="Phonenum" class="block text-sm font-medium leading-6 text-gray-900">郵便番号</label>
          <div class="mt-2">
            		<!-- 郵便番号入力(7桁) -->
		<input type="text" name="PostAdd" size="10" maxlength="8" onKeyUp="AjaxZip3.zip2addr(this,'','Address','Address');" required class="block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400  sm:text-sm sm:leading-6">
          </div>
        </div>
        <div>
          <label for="Address" class="block text-sm font-medium leading-6 text-gray-900">住所</label>
          <div class="mt-2">
            <input id="Address" name="Address" type="text" autocomplete="Address" required class="block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400  sm:text-sm sm:leading-6">
          </div>
        </div>
        <div>
          <label for="MailAdd" class="block text-sm font-medium leading-6 text-gray-900">メールアドレス</label>
          <div class="mt-2">
            <input id="MailAdd" name="MailAdd" type="email" autocomplete="MailAdd" required class="block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400  sm:text-sm sm:leading-6">
          </div>
        </div>
        <!-- 
        <div>
          <label for="Prefecture" class="block text-sm font-medium leading-6 text-gray-900">県</label>
          <div class="mt-2">
            <input id="Prefecture" name="Prefecture" type="Prefecture" autocomplete="Prefecture" required class="block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400  sm:text-sm sm:leading-6">
          </div>
        </div>
         -->
        <div>
	       	<label for="Prefecture" class="block text-sm font-medium leading-6 text-gray-900">県</label>
			    <select name="Prefecture">
				<option value="北海道">北海道</option>
				<option value="青森県">青森県</option>
				<option value="岩手県">岩手県</option>
				<option value="宮城県">宮城県</option>
				<option value="秋田県">秋田県</option>
				<option value="山形県">山形県</option>
				<option value="福島県">福島県</option>
				<option value="茨城県">茨城県</option>
				<option value="栃木県">栃木県</option>
				<option value="群馬県">群馬県</option>
				<option value="埼玉県">埼玉県</option>
				<option value="千葉県">千葉県</option>
				<option value="東京都">東京都</option>
				<option value="神奈川県">神奈川県</option>
				<option value="新潟県">新潟県</option>
				<option value="富山県">富山県</option>
				<option value="石川県">石川県</option>
				<option value="福井県">福井県</option>
				<option value="山梨県">山梨県</option>
				<option value="長野県">長野県</option>
				<option value="岐阜県">岐阜県</option>
				<option value="静岡県">静岡県</option>
				<option value="愛知県">愛知県</option>
				<option value="三重県">三重県</option>
				<option value="滋賀県">滋賀県</option>
				<option value="京都府">京都府</option>
				<option value="大阪府">大阪府</option>
				<option value="兵庫県">兵庫県</option>
				<option value="奈良県">奈良県</option>
				<option value="和歌山県">和歌山県</option>
				<option value="鳥取県">鳥取県</option>
				<option value="島根県">島根県</option>
				<option value="岡山県">岡山県</option>
				<option value="広島県">広島県</option>
				<option value="山口県">山口県</option>
				<option value="徳島県">徳島県</option>
				<option value="香川県">香川県</option>
				<option value="愛媛県">愛媛県</option>
				<option value="高知県">高知県</option>
				<option value="福岡県">福岡県</option>
				<option value="佐賀県">佐賀県</option>
				<option value="長崎県">長崎県</option>
				<option value="熊本県">熊本県</option>
				<option value="大分県">大分県</option>
				<option value="宮崎県">宮崎県</option>
				<option value="鹿児島県">鹿児島県</option>
				<option value="沖縄県">沖縄県</option>
				</select>
		</div>
        
        <div>
          <label for="FN" class="block text-sm font-medium leading-6 text-gray-900">氏名</label>
          <div class="mt-2">
            <input id="FN" name="FN" type="FN" autocomplete="FN" required class="block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400  sm:text-sm sm:leading-6">
          </div>
        </div>
        <div>
          <label for="Cname" class="block text-sm font-medium leading-6 text-gray-900">企業名</label>
          <div class="mt-2">
            <input id="Cname" name="Cname" type="Cname" autocomplete="Cname" required class="block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400  sm:text-sm sm:leading-6">
          </div>
        </div>
        <div>
	       	<label for="gender" class="block text-sm font-medium leading-6 text-gray-900">性別</label>
			    <select name="gender">
				<option value="男性">男性</option>
				<option value="女性">女性</option>
				<option value="未回答">未回答</option>
				</select>
		</div>
        <div>
          <label for="Department" class="block text-sm font-medium leading-6 text-gray-900">部署・課</label>
          <div class="mt-2">
            <input id="Department" name="Department" type="Department" autocomplete="Department" required class="block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400  sm:text-sm sm:leading-6">
          </div>
        </div>
        <div>
          <button type="submit" class="flex w-full justify-center rounded-md bg-indigo-600 px-3 py-1.5 text-sm font-semibold leading-6 text-white shadow-sm hover:bg-indigo-500 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600">登録</button>
        </div>
      </form>
  
      <p class="mt-10 text-center text-sm text-gray-500">
        ログインする方は
        <a href="index.jsp" class="font-semibold leading-6 text-indigo-600 hover:text-indigo-500">こちら</a>
      </p>
    </div>
  </div>
  