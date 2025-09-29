import React, { useState } from "react";
import SectionCard from "../components/SectionCard";

export default function MyPage() {
  const [walletReport, setWalletReport] = useState<string>("");
  const [webhookReport, setWebhookReport] = useState<string>("");

  const fetchConsistency = async () => {
    const res = await fetch("http://localhost:8080/monitoring/wallets/consistency");
    const text = await res.text();
    setWalletReport(text);
  };

  const retryWebhooks = async () => {
    const res = await fetch("http://localhost:8080/monitoring/webhooks/retry", { method: "POST" });
    const text = await res.text();
    setWebhookReport(text);
  };

  return (
    <div className="max-w-5xl p-8 mx-auto space-y-8">
      <h1 className="mb-6 text-2xl font-bold text-slate-900">📊 마이페이지</h1>

      {/* Wallet Consistency */}
      <SectionCard title="Wallet Consistency" description="DB balance vs Ledger 합계 검증">
        <button
          onClick={fetchConsistency}
          className="px-4 py-2 text-white bg-blue-600 rounded-lg hover:bg-blue-700"
        >
          검사 실행
        </button>
        {walletReport && (
          <pre className="p-3 mt-4 text-sm whitespace-pre-wrap rounded bg-slate-100">
            {walletReport}
          </pre>
        )}
      </SectionCard>

      {/* Webhook Retry */}
      <SectionCard title="Webhook 재처리" description="FAILED 상태의 Webhook 이벤트 재처리">
        <button
          onClick={retryWebhooks}
          className="px-4 py-2 text-white bg-green-600 rounded-lg hover:bg-green-700"
        >
          재처리 실행
        </button>
        {webhookReport && (
          <pre className="p-3 mt-4 text-sm whitespace-pre-wrap rounded bg-slate-100">
            {webhookReport}
          </pre>
        )}
      </SectionCard>

      {/* TODO: 결제/환불/정산 내역 조회는 Table UI로 */}
      <SectionCard title="결제/환불/정산 내역">
        <p className="text-slate-500">➡ 추후 API 연동 시, Table 형태로 출력 예정</p>
      </SectionCard>

      {/* Admin Reconcile */}
      <SectionCard title="Admin Reconcile" description="관리자 지갑 잔액과 원장 불일치 자동 조정">
        <button
          onClick={() => fetch("http://localhost:8080/admin/reconcile/wallets", { method: "POST" })}
          className="px-4 py-2 text-white bg-red-600 rounded-lg hover:bg-red-700"
        >
          불일치 조정 실행
        </button>
      </SectionCard>
    </div>
  );
}
