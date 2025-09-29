import React from "react";

interface SectionCardProps {
  title: string;
  description?: string;
  children: React.ReactNode;
}

export default function SectionCard({ title, description, children }: SectionCardProps) {
  return (
    <div className="p-6 bg-white border shadow rounded-2xl border-slate-200">
      <h2 className="text-lg font-semibold text-slate-800">{title}</h2>
      {description && <p className="mb-3 text-sm text-slate-500">{description}</p>}
      <div>{children}</div>
    </div>
  );
}