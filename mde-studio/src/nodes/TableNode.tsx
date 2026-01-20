import React, { memo } from 'react';
import { Handle, Position } from 'reactflow';
import { Database, Plus, Trash2, Key, Hash, Type, Calendar, CheckSquare, AlignLeft } from 'lucide-react';

const TypeIcon = ({ type }: { type: string }) => {
    switch (type) {
        case 'LONG':
        case 'INTEGER':
            return <Hash size={12} className="text-blue-500" />;
        case 'BOOLEAN':
            return <CheckSquare size={12} className="text-emerald-500" />;
        case 'DATE':
            return <Calendar size={12} className="text-amber-500" />;
        case 'STRING':
            return <Type size={12} className="text-indigo-500" />;
        default:
            return <AlignLeft size={12} className="text-slate-400" />;
    }
};

export default memo(({ data, id, selected }: any) => {
    const { label, columns, onDelete, onAddColumn, onRemoveColumn, onUpdateColumnName, onUpdateTableName, onUpdateColumnType, onUpdateColumnPk } = data;

    return (
        <div className={`glass-card min-w-[180px] transition-all duration-200 ${selected ? 'ring-2 ring-blue-500/50 scale-105' : 'hover:border-white/60'}`}>
            {/* Compact Header */}
            <div className="bg-white/50 border-b border-slate-200/50 p-1.5 flex items-center justify-between rounded-t-xl">
                <div className="flex items-center gap-1.5 flex-1 min-w-0">
                    <div className="p-1 bg-gradient-to-br from-blue-500 to-indigo-600 text-white rounded-md shadow-sm">
                        <Database size={12} />
                    </div>
                    <input
                        className="font-bold text-slate-800 bg-transparent border-none focus:ring-0 w-full p-0 text-xs placeholder:text-slate-400"
                        value={label}
                        onChange={(e) => onUpdateTableName(id, e.target.value)}
                        placeholder="Table"
                    />
                </div>
                <button
                    onClick={() => onDelete(id)}
                    className="text-slate-400 hover:text-red-500 transition-colors p-1 hover:bg-red-50 rounded group"
                >
                    <Trash2 size={12} className="group-hover:scale-110 transition-transform" />
                </button>
            </div>

            {/* Compact Columns */}
            <div className="p-1.5 space-y-1">
                {columns.map((col: any, idx: number) => (
                    <div key={idx} className="flex items-center gap-1.5 group relative bg-white/40 p-1 rounded border border-transparent hover:border-white/60 hover:bg-white/60 transition-all">
                        {/* Single centered handle on each side */}
                        <Handle 
                            type="target" 
                            position={Position.Left} 
                            id={`${id}-${idx}-target`}
                            className="!w-2 !h-2 !bg-blue-500 !border-2 !border-white hover:!scale-150 transition-transform"
                            style={{ top: '50%', transform: 'translateY(-50%)' }}
                        />

                        <div className="flex items-center gap-1 flex-1 min-w-0">
                            <button
                                onClick={() => onUpdateColumnPk(id, idx, !col.pk)}
                                className={`transition-colors focus:outline-none ${col.pk ? 'text-amber-500' : 'text-slate-300 hover:text-slate-400'}`}
                                title="Primary Key"
                            >
                                <Key size={11} className={col.pk ? 'fill-amber-500/20' : ''} />
                            </button>

                            <input
                                className="flex-1 text-[11px] font-medium bg-transparent border-none p-0 text-slate-700 focus:ring-0 outline-none min-w-0 truncate placeholder:text-slate-300"
                                value={col.name}
                                onChange={(e) => onUpdateColumnName(id, idx, e.target.value)}
                                placeholder="name"
                            />
                        </div>

                        <div className="flex items-center gap-1">
                            <div className="flex items-center gap-0.5 bg-slate-100/50 px-1 py-0.5 rounded">
                                <TypeIcon type={col.type} />
                                <select
                                    className="text-[8px] font-bold tracking-wider uppercase bg-transparent border-none p-0 text-slate-500 focus:ring-0 outline-none cursor-pointer"
                                    value={col.type}
                                    onChange={(e) => onUpdateColumnType(id, idx, e.target.value)}
                                >
                                    <option value="LONG">Long</option>
                                    <option value="STRING">Str</option>
                                    <option value="INTEGER">Int</option>
                                    <option value="BOOLEAN">Bool</option>
                                    <option value="DATE">Date</option>
                                    <option value="TEXT">Text</option>
                                </select>
                            </div>

                            <button
                                onClick={() => onRemoveColumn(id, idx)}
                                className="text-slate-300 hover:text-red-500 opacity-0 group-hover:opacity-100 transition-all p-0.5 hover:bg-red-50 rounded"
                            >
                                <Trash2 size={10} />
                            </button>
                        </div>

                        <Handle 
                            type="source" 
                            position={Position.Right} 
                            id={`${id}-${idx}-source`}
                            className="!w-2 !h-2 !bg-indigo-500 !border-2 !border-white hover:!scale-150 transition-transform"
                            style={{ top: '50%', transform: 'translateY(-50%)' }}
                        />
                    </div>
                ))}

                <button
                    onClick={() => onAddColumn(id)}
                    className="w-full mt-0.5 py-1 border border-dashed border-slate-200 text-slate-400 rounded text-[10px] font-medium hover:border-blue-400 hover:text-blue-500 hover:bg-blue-50/50 transition-all flex items-center justify-center gap-1 group"
                >
                    <Plus size={11} className="group-hover:rotate-90 transition-transform" /> Column
                </button>
            </div>
        </div>
    );
});