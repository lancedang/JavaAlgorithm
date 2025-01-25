package com.dangdang.JavaAlgorithm;

import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {

        ttt();
    }


    public static void ttt() {
        ArrayList<String> a1 = new ArrayList<>();

        String st1 = "bus-jgt-account,bus-frp-job,bus-trade-asyn-order,bus-prd,bus-ops-trade,bus-frp-rdf,bus-jgt-trade,bus-trade-query,bus-asset,bus-account,bus-open-piccamc,fofund-fap-oms,bus-jgt-common,bus-prd-core,bus-trade,basic-prd,fofund-fap,bus-ops-open,bus-report-core,bus-report-task,bus-account-task,bus-frp-aat,bus-opr-mgt-web,bus-frp-rdf-mirror,bus-frp-auth,bus-open-o32v2,bus-open-fisp,bus-account-query,bus-account-contract,bus-frp-fmi-web,bus-trade-sync,bus-account-core,bus-open-api,bus-open-joyin,bus-open-std,bus-open-ia,bus-open-xquant,bus-frp-fpr-web,bus-frp-bfs-web,bus-frp-fpm-web,bus-frp-customization,bus-open-std-custodian,bus-open-fisp-imitate,bus-open-fdep-core,bus-frp-fes-web,bus-capital-channel,basic-prd-engine,bus-open-bcm-trust,bus-frp-swa-web,bus-open-cib-trust,bus-frp-report-web,bus-ops-account,bus-trade-credit,bus-oms-common,bus-frp-file-web,basic-asset,fofund-openapi-welink,bus-cms,bus-unit-file,basic-prd-ocean,basic-account,basic-trade";
        String st2 = "https://open.feishu.cn/open-apis/bot/v2/hook/9fbe8a49-e7f8-4a5a-848b-a12e21bc39c5,https://open.feishu.cn/open-apis/bot/v2/hook/f307a4ac-a39d-4f75-a478-fed96215a92b,https://open.feishu.cn/open-apis/bot/v2/hook/9fbe8a49-e7f8-4a5a-848b-a12e21bc39c5,https://open.feishu.cn/open-apis/bot/v2/hook/27dd8f61-1d25-4604-b5cb-47c9dfc78db7,https://open.feishu.cn/open-apis/bot/v2/hook/9fbe8a49-e7f8-4a5a-848b-a12e21bc39c5,https://open.feishu.cn/open-apis/bot/v2/hook/f307a4ac-a39d-4f75-a478-fed96215a92b,https://open.feishu.cn/open-apis/bot/v2/hook/9fbe8a49-e7f8-4a5a-848b-a12e21bc39c5,https://open.feishu.cn/open-apis/bot/v2/hook/9fbe8a49-e7f8-4a5a-848b-a12e21bc39c5,https://open.feishu.cn/open-apis/bot/v2/hook/9fbe8a49-e7f8-4a5a-848b-a12e21bc39c5,https://open.feishu.cn/open-apis/bot/v2/hook/9fbe8a49-e7f8-4a5a-848b-a12e21bc39c5,https://open.feishu.cn/open-apis/bot/v2/hook/d5dee857-cede-4f06-b809-245f89ac14db,https://open.feishu.cn/open-apis/bot/v2/hook/9fbe8a49-e7f8-4a5a-848b-a12e21bc39c5,https://open.feishu.cn/open-apis/bot/v2/hook/9fbe8a49-e7f8-4a5a-848b-a12e21bc39c5,https://open.feishu.cn/open-apis/bot/v2/hook/27dd8f61-1d25-4604-b5cb-47c9dfc78db7,https://open.feishu.cn/open-apis/bot/v2/hook/9fbe8a49-e7f8-4a5a-848b-a12e21bc39c5,https://open.feishu.cn/open-apis/bot/v2/hook/27dd8f61-1d25-4604-b5cb-47c9dfc78db7,https://open.feishu.cn/open-apis/bot/v2/hook/9fbe8a49-e7f8-4a5a-848b-a12e21bc39c5,https://open.feishu.cn/open-apis/bot/v2/hook/d5dee857-cede-4f06-b809-245f89ac14db,https://open.feishu.cn/open-apis/bot/v2/hook/9fbe8a49-e7f8-4a5a-848b-a12e21bc39c5,https://open.feishu.cn/open-apis/bot/v2/hook/9fbe8a49-e7f8-4a5a-848b-a12e21bc39c5,https://open.feishu.cn/open-apis/bot/v2/hook/9fbe8a49-e7f8-4a5a-848b-a12e21bc39c5,https://open.feishu.cn/open-apis/bot/v2/hook/f307a4ac-a39d-4f75-a478-fed96215a92b,https://open.feishu.cn/open-apis/bot/v2/hook/27dd8f61-1d25-4604-b5cb-47c9dfc78db7,https://open.feishu.cn/open-apis/bot/v2/hook/f307a4ac-a39d-4f75-a478-fed96215a92b,https://open.feishu.cn/open-apis/bot/v2/hook/f307a4ac-a39d-4f75-a478-fed96215a92b,https://open.feishu.cn/open-apis/bot/v2/hook/d5dee857-cede-4f06-b809-245f89ac14db,https://open.feishu.cn/open-apis/bot/v2/hook/d5dee857-cede-4f06-b809-245f89ac14db,https://open.feishu.cn/open-apis/bot/v2/hook/9fbe8a49-e7f8-4a5a-848b-a12e21bc39c5,https://open.feishu.cn/open-apis/bot/v2/hook/9fbe8a49-e7f8-4a5a-848b-a12e21bc39c5,https://open.feishu.cn/open-apis/bot/v2/hook/f307a4ac-a39d-4f75-a478-fed96215a92b,https://open.feishu.cn/open-apis/bot/v2/hook/9fbe8a49-e7f8-4a5a-848b-a12e21bc39c5,https://open.feishu.cn/open-apis/bot/v2/hook/9fbe8a49-e7f8-4a5a-848b-a12e21bc39c5,https://open.feishu.cn/open-apis/bot/v2/hook/d5dee857-cede-4f06-b809-245f89ac14db,https://open.feishu.cn/open-apis/bot/v2/hook/d5dee857-cede-4f06-b809-245f89ac14db,https://open.feishu.cn/open-apis/bot/v2/hook/d5dee857-cede-4f06-b809-245f89ac14db,https://open.feishu.cn/open-apis/bot/v2/hook/d5dee857-cede-4f06-b809-245f89ac14db,https://open.feishu.cn/open-apis/bot/v2/hook/d5dee857-cede-4f06-b809-245f89ac14db,https://open.feishu.cn/open-apis/bot/v2/hook/f307a4ac-a39d-4f75-a478-fed96215a92b,https://open.feishu.cn/open-apis/bot/v2/hook/f307a4ac-a39d-4f75-a478-fed96215a92b,https://open.feishu.cn/open-apis/bot/v2/hook/f307a4ac-a39d-4f75-a478-fed96215a92b,https://open.feishu.cn/open-apis/bot/v2/hook/f307a4ac-a39d-4f75-a478-fed96215a92b,https://open.feishu.cn/open-apis/bot/v2/hook/d5dee857-cede-4f06-b809-245f89ac14db,https://open.feishu.cn/open-apis/bot/v2/hook/d5dee857-cede-4f06-b809-245f89ac14db,https://open.feishu.cn/open-apis/bot/v2/hook/d5dee857-cede-4f06-b809-245f89ac14db,https://open.feishu.cn/open-apis/bot/v2/hook/f307a4ac-a39d-4f75-a478-fed96215a92b,https://open.feishu.cn/open-apis/bot/v2/hook/27dd8f61-1d25-4604-b5cb-47c9dfc78db7,https://open.feishu.cn/open-apis/bot/v2/hook/27dd8f61-1d25-4604-b5cb-47c9dfc78db7,https://open.feishu.cn/open-apis/bot/v2/hook/d5dee857-cede-4f06-b809-245f89ac14db,https://open.feishu.cn/open-apis/bot/v2/hook/f307a4ac-a39d-4f75-a478-fed96215a92b,https://open.feishu.cn/open-apis/bot/v2/hook/d5dee857-cede-4f06-b809-245f89ac14db,https://open.feishu.cn/open-apis/bot/v2/hook/f307a4ac-a39d-4f75-a478-fed96215a92b,https://open.feishu.cn/open-apis/bot/v2/hook/9fbe8a49-e7f8-4a5a-848b-a12e21bc39c5,https://open.feishu.cn/open-apis/bot/v2/hook/9fbe8a49-e7f8-4a5a-848b-a12e21bc39c5,https://open.feishu.cn/open-apis/bot/v2/hook/27dd8f61-1d25-4604-b5cb-47c9dfc78db7,https://open.feishu.cn/open-apis/bot/v2/hook/f307a4ac-a39d-4f75-a478-fed96215a92b,https://open.feishu.cn/open-apis/bot/v2/hook/9fbe8a49-e7f8-4a5a-848b-a12e21bc39c5,https://open.feishu.cn/open-apis/bot/v2/hook/d5dee857-cede-4f06-b809-245f89ac14db,https://open.feishu.cn/open-apis/bot/v2/hook/9fbe8a49-e7f8-4a5a-848b-a12e21bc39c5,https://open.feishu.cn/open-apis/bot/v2/hook/d5dee857-cede-4f06-b809-245f89ac14db,https://open.feishu.cn/open-apis/bot/v2/hook/27dd8f61-1d25-4604-b5cb-47c9dfc78db7,https://open.feishu.cn/open-apis/bot/v2/hook/9fbe8a49-e7f8-4a5a-848b-a12e21bc39c5,https://open.feishu.cn/open-apis/bot/v2/hook/9fbe8a49-e7f8-4a5a-848b-a12e21bc39c5";

        String[] t1 = st1.split(",");
        String[] t2 = st2.split(",");

        String ttt = "\n" +
                "curl -i -H \"Content-Type:application/json\" -X POST \\\n" +
                "-d '{\"serviceName\":\"bus-link-trade-api\",\"contactAddress\":\"https://open.feishu.cn/open-apis/bot/v2/hook/d5dee857-cede-4f06-b809-245f89ac14db\",\"endTime\":\"2024-06-13 20:20:33\",\"type\":\"0,1\"}' \\\n" +
                "http://localhost:8080/fofund-alarm-dispatcher/alarm/business/downgrade\n" +
                "\n" +
                "\n";


        for (int i = 0; i < t1.length; i++) {
            String appName = t1[i];
            String webhook = t2[i];
            String ttt2 =
                    "curl -i -H \"Content-Type:application/json\" -X POST \\\n" +
                    "-d '{\"serviceName\":\"" + appName + "\",\"contactAddress\":\"" + webhook + "\",\"endTime\":\"2024-06-13 20:20:33\",\"type\":\"0,1\"}' \\\n" +
                    "http://localhost:8080/fofund-alarm-dispatcher/alarm/business/downgrade\n";
            a1.add(ttt2);
        }

        for (String s : a1) {
            System.out.println(s);
        }

    }

    public static void change(String str, char[] arr) {
        str = "hello";
        arr[0] = '1';
    }

    int i = 2;

    public void show(int i) {
        this.i++;
        i++;
    }

}
