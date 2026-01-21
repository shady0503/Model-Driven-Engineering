import React, { useCallback, useState } from 'react';
import ReactFlow, {
  Background,
  Controls,
  addEdge,
  useNodesState,
  useEdgesState,
  MarkerType,
  ConnectionMode
} from 'reactflow';
import type { Connection, Edge } from 'reactflow';
import 'reactflow/dist/style.css';
import axios from 'axios';
import { Download, Plus, Settings, Trash2, GitBranch } from 'lucide-react';
import TableNode from './nodes/TableNode';

const nodeTypes = {
  table: TableNode,
};

const initialNodes: any[] = [];

const edgeOptions = {
  animated: true,
  style: { stroke: '#3b82f6', strokeWidth: 2 },
  markerEnd: { type: MarkerType.ArrowClosed, color: '#3b82f6' },
};

export default function App() {
  const [nodes, setNodes, onNodesChange] = useNodesState(initialNodes);
  const [edges, setEdges, onEdgesChange] = useEdgesState([]);

  // Project Settings
  const [projectName, setProjectName] = useState("GeneratedProject");
  const [groupId, setGroupId] = useState("com.example");
  const [version, setVersion] = useState("0.0.1");
  const [dbType, setDbType] = useState("POSTGRESQL");
  const [language, setLanguage] = useState("JAVA");

  const [showModal, setShowModal] = useState(false);
  const [contextMenu, setContextMenu] = useState<{ x: number; y: number; edge: Edge } | null>(null);

  // --- Actions ---

  const onConnect = useCallback((params: Connection) => {
    if (!params.source || !params.target) return;
    // If user connected via column handles, keep them (TableNode emits handle ids like `${nodeId}-${colIdx}-source`)
    const sourceHandle = params.sourceHandle || undefined;
    const targetHandle = params.targetHandle || undefined;
    const edge: Edge = {
      ...params,
      source: params.source,
      target: params.target,
      // Include handles so multiple relations between same tables are possible
      id: `${params.source}-${sourceHandle || 'source'}__${params.target}-${targetHandle || 'target'}`,
      type: 'smoothstep',
      animated: true,
      style: { stroke: '#3b82f6', strokeWidth: 2 },
      markerEnd: { type: MarkerType.ArrowClosed, color: '#3b82f6' },
      data: {
        sourceHandle,
        targetHandle,
        relationType: 'MANY_TO_ONE',
        owner: true,
        fetch: 'LAZY',
        cascade: 'ALL',
        optional: true
      },
      label: '∞ → 1',
      labelStyle: { fill: '#3b82f6', fontWeight: 700, fontSize: 12 },
      labelBgStyle: { fill: 'white', fillOpacity: 0.95 },
      labelBgPadding: [6, 3],
      labelBgBorderRadius: 6,
    };
    setEdges((eds) => addEdge(edge, eds));
  }, [setEdges]);

  const onEdgeContextMenu = useCallback((event: React.MouseEvent, edge: Edge) => {
    event.preventDefault();
    setContextMenu({
      x: event.clientX,
      y: event.clientY,
      edge,
    });
  }, []);

  const updateEdgeRelationType = (edgeId: string, relationType: string) => {
    setEdges((eds) =>
      eds.map((edge) => {
        if (edge.id === edgeId) {
          const relationConfig: Record<string, { label: string; color: string; animated: boolean; markerStart?: any; markerEnd?: any }> = {
            'ONE_TO_ONE': {
              label: '1 → 1',
              color: '#8b5cf6',
              animated: false,
              markerEnd: { type: MarkerType.ArrowClosed, color: '#8b5cf6' },
            },
            'ONE_TO_MANY': {
              label: '1 → ∞',
              color: '#10b981',
              animated: false,
              markerEnd: { type: MarkerType.ArrowClosed, color: '#10b981' },
            },
            'MANY_TO_ONE': {
              label: '∞ → 1',
              color: '#3b82f6',
              animated: false,
              markerEnd: { type: MarkerType.ArrowClosed, color: '#3b82f6' },
            },
            'MANY_TO_MANY': {
              label: '∞ ↔ ∞',
              color: '#f59e0b',
              animated: true,
              markerStart: { type: MarkerType.ArrowClosed, color: '#f59e0b' },
              markerEnd: { type: MarkerType.ArrowClosed, color: '#f59e0b' },
            },
          };
          const config = relationConfig[relationType];
          let newOwner = edge.data?.owner;
          if (relationType === 'MANY_TO_ONE') newOwner = true;
          else if (relationType === 'ONE_TO_MANY') newOwner = false;
          else if (newOwner === undefined) newOwner = true; // Default for others

          return {
            ...edge,
            data: {
              ...edge.data,
              relationType,
              owner: newOwner,
              fetch: 'LAZY',
              cascade: edge.data?.cascade || 'ALL',
              optional: edge.data?.optional !== undefined ? edge.data.optional : true
            },
            label: config.label,
            animated: config.animated,
            style: { stroke: config.color, strokeWidth: 2.5 },
            labelStyle: { fill: config.color, fontWeight: 700, fontSize: 12 },
            labelBgStyle: { fill: 'white', fillOpacity: 0.95 },
            labelBgPadding: [6, 3],
            labelBgBorderRadius: 6,
            markerStart: config.markerStart,
            markerEnd: config.markerEnd,
          };
        }
        return edge;
      })
    );
    setContextMenu(null);
  };

  const deleteEdge = (edgeId: string) => {
    setEdges((eds) => eds.filter((e) => e.id !== edgeId));
    setContextMenu(null);
  };

  const addTable = () => {
    const id = Math.random().toString(36).substr(2, 9);
    const newNode = {
      id,
      type: 'table',
      position: { x: 300 + Math.random() * 300, y: 100 + Math.random() * 300 },
      data: {
        label: 'NewTable',
        columns: [{ name: 'id', type: 'LONG', pk: true }],
        onDelete: (id: string) => {
          setNodes((nds) => nds.filter((n) => n.id !== id));
          setEdges((eds) => eds.filter((e) => e.source !== id && e.target !== id));
        },
        onAddColumn: (id: string) => updateNodeData(id, (data: any) => ({
          ...data,
          columns: [...data.columns, { name: 'new_col', type: 'STRING', pk: false }]
        })),
        onRemoveColumn: (id: string, idx: number) => updateNodeData(id, (data: any) => ({
          ...data,
          columns: data.columns.filter((_: any, i: number) => i !== idx)
        })),
        onUpdateTableName: (id: string, name: string) => updateNodeData(id, (data: any) => ({
          ...data,
          label: name
        })),
        onUpdateColumnName: (id: string, idx: number, name: string) => updateNodeData(id, (data: any) => {
          const newCols = [...data.columns];
          newCols[idx].name = name;
          return { ...data, columns: newCols };
        }),
        onUpdateColumnType: (id: string, idx: number, type: string) => updateNodeData(id, (data: any) => {
          const newCols = [...data.columns];
          newCols[idx].type = type;
          return { ...data, columns: newCols };
        }),
        onUpdateColumnPk: (id: string, idx: number, pk: boolean) => updateNodeData(id, (data: any) => {
          const newCols = [...data.columns];
          newCols[idx].pk = pk;
          return { ...data, columns: newCols };
        }),
      },
    };
    setNodes((nds) => nds.concat(newNode));
  };

  const updateNodeData = (id: string, updateFn: (data: any) => any) => {
    setNodes((nds) => nds.map((node) => {
      if (node.id === id) {
        return { ...node, data: { ...node.data, ...updateFn(node.data) } };
      }
      return node;
    }));
  };

  // Hydrate initial nodes with callbacks
  React.useEffect(() => {
    setNodes((nds) => nds.map(n => ({
      ...n,
      data: {
        ...n.data,
        onDelete: (id: string) => {
          setNodes((nds) => nds.filter((n) => n.id !== id));
          setEdges((eds) => eds.filter((e) => e.source !== id && e.target !== id));
        },
        onAddColumn: (id: string) => updateNodeData(id, (data: any) => ({
          ...data,
          columns: [...data.columns, { name: 'new_col', type: 'STRING', pk: false }]
        })),
        onRemoveColumn: (id: string, idx: number) => updateNodeData(id, (data: any) => ({
          ...data,
          columns: data.columns.filter((_: any, i: number) => i !== idx)
        })),
        onUpdateTableName: (id: string, name: string) => updateNodeData(id, (data: any) => ({
          ...data,
          label: name
        })),
        onUpdateColumnName: (id: string, idx: number, name: string) => updateNodeData(id, (data: any) => {
          const newCols = [...data.columns];
          newCols[idx].name = name;
          return { ...data, columns: newCols };
        }),
        onUpdateColumnType: (id: string, idx: number, type: string) => updateNodeData(id, (data: any) => {
          const newCols = [...data.columns];
          newCols[idx].type = type;
          return { ...data, columns: newCols };
        }),
        onUpdateColumnPk: (id: string, idx: number, pk: boolean) => updateNodeData(id, (data: any) => {
          const newCols = [...data.columns];
          newCols[idx].pk = pk;
          return { ...data, columns: newCols };
        }),
      }
    })));
  }, []);

  const triggerGeneration = async () => {
    setShowModal(false);
    
    const getColumnNameFromHandle = (nodeId: string, handleId?: string) => {
      if (!handleId) return undefined;
      // handleId format: `${nodeId}-${idx}-source` or `${nodeId}-${idx}-target`
      const parts = handleId.split('-');
      if (parts.length < 3) return undefined;
      const idxStr = parts[parts.length - 2];
      const idx = Number(idxStr);
      if (!Number.isFinite(idx)) return undefined;
      const node = nodes.find((n: any) => n.id === nodeId);
      const col = node?.data?.columns?.[idx];
      return col?.name as string | undefined;
    };
    
    const tables = nodes.map(node => ({
      Table: {
        name: node.data.label,
        columns: node.data.columns.map((col: any) => ({
          Column: {
            name: col.name,
            type: col.type,
            primary: col.pk
          }
        })),
        relations: edges
          .filter(edge => edge.source === node.id)
          .map(edge => {
            const targetNode = nodes.find(n => n.id === edge.target);
            if (!targetNode) return null;

            const relationType = edge.data?.relationType || "ONE_TO_MANY";

            // Enforce ownership rules during generation
            let isOwner = edge.data?.owner;
            if (relationType === 'MANY_TO_ONE') isOwner = true;
            if (relationType === 'ONE_TO_MANY') isOwner = false;
            if (isOwner === undefined && (relationType === 'MANY_TO_MANY' || relationType === 'ONE_TO_ONE')) {
              isOwner = true; // Default for many-to-many/one-to-one
            }

            const relationData: any = {
              targetTable: targetNode.data.label,
              type: relationType,
              owner: isOwner,
              fetch: 'LAZY', // Force LAZY
              cascade: edge.data?.cascade || 'ALL',
            };

            // Deterministic Join Table and Column naming for owners
            if (isOwner) {
              if (relationType === 'MANY_TO_MANY') {
                const source = node.data.label.toLowerCase();
                const target = targetNode.data.label.toLowerCase();
                // Consistent naming: alphabetize to ensure same name from both sides if model had it
                const parts = [source, target].sort();
                relationData.joinTableName = `${parts[0]}_${parts[1]}_map`;
                relationData.joinColumnName = `${source}_id`;
                relationData.inverseJoinColumnName = `${target}_id`;
              } else if (relationType === 'MANY_TO_ONE' || relationType === 'ONE_TO_ONE') {
                // If edge was created from a specific column, use that column as join column name
                const chosenColumn = getColumnNameFromHandle(edge.source, edge.data?.sourceHandle);
                relationData.joinColumnName = chosenColumn || `${targetNode.data.label.toLowerCase()}_id`;
              }
            } else {
              // For inverse side, provide mappedBy (heuristic: source table name)
              relationData.mappedBy = node.data.label.toLowerCase();
            }

            if (edge.data?.optional !== undefined) {
              relationData.optional = edge.data.optional;
            } else {
              relationData.optional = true;
            }

            return { Relation: relationData };
          })
          .filter(Boolean)
      }
    }));

    const payload = {
      BackendConfig: {
        project: {
          Project: {
            name: projectName,
            groupId: groupId,
            version: version,
            language: language,
            framework: "SPRING_BOOT"
          }
        },
        database: {
          Database: {
            name: "mydb",
            type: dbType,
            tables: tables
          }
        }
      }
    };

    const toYaml = (obj: any, indent = 0): string => {
      let yaml = "";
      const spaces = " ".repeat(indent);
      for (const key in obj) {
        const val = obj[key];
        if (Array.isArray(val)) {
          yaml += `${spaces}${key}:\n`;
          val.forEach(item => {
            if (typeof item === 'object') {
              const keys = Object.keys(item);
              if (keys.length === 1) {
                const k = keys[0];
                const v = item[k];
                yaml += `${spaces}  - ${k}:\n${toYaml(v, indent + 6)}`;
              } else {
                yaml += `${spaces}  - \n${toYaml(item, indent + 4)}`;
              }
            }
          });
        } else if (typeof val === 'object' && val !== null) {
          yaml += `${spaces}${key}:\n${toYaml(val, indent + 2)}`;
        } else {
          yaml += `${spaces}${key}: ${val}\n`;
        }
      }
      return yaml;
    };

    const yamlString = toYaml(payload);

    try {
      const response = await axios.post('http://localhost:8090/api/v1/generate', yamlString, {
        responseType: 'blob',
        headers: { 'Content-Type': 'text/plain' }
      });
      const url = window.URL.createObjectURL(new Blob([response.data]));
      const link = document.createElement('a');
      link.href = url;
      link.setAttribute('download', `${projectName}.zip`);
      document.body.appendChild(link);
      link.click();
      link.remove();
    } catch (e) {
      console.error("Generation failed", e);
      alert("Generation failed. Check console.");
    }
  };

  return (
    <div className="w-full h-screen flex flex-col bg-slate-100" onClick={() => setContextMenu(null)}>
      {/* Compact Header */}
      <header className="glass-header px-6 py-2 flex items-center justify-between shadow-xl shadow-blue-500/5">
        <div className="flex items-center gap-3">
          <div className="bg-gradient-to-br from-blue-600 to-indigo-700 text-white p-1.5 rounded-lg font-black text-base shadow-lg shadow-blue-600/20">
            MDE
          </div>
          <div>
            <h1 className="text-base font-black text-slate-900 tracking-tight leading-tight">Studio</h1>
            <div className="flex items-center gap-1 opacity-50">
              <div className="w-1 h-1 bg-emerald-500 rounded-full animate-pulse" />
              <span className="text-[8px] font-bold uppercase tracking-widest text-slate-500">Ready</span>
            </div>
          </div>
        </div>

        <div className="flex gap-2">
          <button
            onClick={addTable}
            className="group flex items-center gap-1.5 px-3 py-1.5 bg-white border border-slate-200 rounded-lg hover:bg-slate-50 font-bold text-slate-700 text-xs transition-all hover:shadow-md"
          >
            <Plus size={14} className="text-blue-600 group-hover:rotate-90 transition-transform" />
            Table
          </button>
          <button
            onClick={() => setShowModal(true)}
            className="flex items-center gap-1.5 px-4 py-1.5 bg-gradient-to-r from-blue-600 to-indigo-600 text-white rounded-lg hover:shadow-xl hover:shadow-blue-500/30 transition-all font-bold text-xs group"
          >
            <Download size={14} className="group-hover:translate-y-0.5 transition-transform" />
            Generate
          </button>
        </div>
      </header>

      <main className="flex-1 relative bg-[radial-gradient(#e2e8f0_1px,transparent_1px)] [background-size:20px_20px]">
        <ReactFlow
          nodes={nodes}
          edges={edges}
          onNodesChange={onNodesChange}
          onEdgesChange={onEdgesChange}
          onConnect={onConnect}
          onEdgeContextMenu={onEdgeContextMenu}
          nodeTypes={nodeTypes}
          defaultEdgeOptions={edgeOptions}
          connectionMode={ConnectionMode.Loose}
          fitView
          className="bg-transparent"
          minZoom={0.2}
          maxZoom={2}
        >
          <Background color="#cbd5e1" gap={20} size={1} />
          <Controls className="!bottom-6 !left-6 overflow-hidden rounded-lg border-none shadow-xl" />
        </ReactFlow>

        {/* Welcome Modal */}
        {nodes.length === 0 && (
          <div className="absolute inset-0 flex items-center justify-center pointer-events-none z-40">
            <div className="glass-card p-10 text-center shadow-2xl animate-in fade-in zoom-in duration-500 pointer-events-auto max-w-sm ring-4 ring-white/50">
              <div className="w-20 h-20 bg-gradient-to-br from-blue-50 to-indigo-50 text-blue-600 rounded-3xl flex items-center justify-center mx-auto mb-6 shadow-inner border border-white/50">
                <Plus size={40} className="drop-shadow-sm" />
              </div>
              <h2 className="text-2xl font-black text-slate-800 mb-3 tracking-tight">Your Canvas is Empty</h2>
              <p className="text-slate-500 font-medium mb-8 leading-relaxed">
                Start designing your database schema by adding your first table.
              </p>
              <button
                onClick={addTable}
                className="w-full py-3.5 bg-gradient-to-r from-blue-600 to-indigo-600 text-white font-bold text-sm rounded-xl shadow-xl shadow-blue-600/20 hover:shadow-blue-600/40 hover:-translate-y-0.5 transition-all flex items-center justify-center gap-2.5 group"
              >
                <Plus size={18} className="group-hover:rotate-90 transition-transform" />
                Create First Table
              </button>
            </div>
          </div>
        )}

        {/* Relationship Legend */}
        <div className="absolute bottom-6 right-6 glass-card p-3 min-w-[200px] shadow-xl">
          <div className="flex items-center gap-2 mb-2 pb-2 border-b border-slate-200">
            <GitBranch size={14} className="text-slate-600" />
            <span className="text-xs font-bold text-slate-700">Relationship Types</span>
          </div>
          <div className="space-y-1.5">
            {[
              { label: '1 → 1', name: 'One-to-One', color: '#8b5cf6' },
              { label: '1 → ∞', name: 'One-to-Many', color: '#10b981' },
              { label: '∞ → 1', name: 'Many-to-One', color: '#3b82f6' },
              { label: '∞ ↔ ∞', name: 'Many-to-Many', color: '#f59e0b' },
            ].map(({ label, name, color }) => (
              <div key={name} className="flex items-center gap-2">
                <div className="flex items-center gap-1 min-w-[50px]">
                  <div className="w-6 h-0.5 rounded" style={{ backgroundColor: color }} />
                  <div className="w-1.5 h-1.5 rounded-full" style={{ backgroundColor: color }} />
                </div>
                <span className="text-[10px] font-bold" style={{ color }}>{label}</span>
                <span className="text-[9px] text-slate-500">{name}</span>
              </div>
            ))}
          </div>
          <div className="mt-2 pt-2 border-t border-slate-200">
            <p className="text-[8px] text-slate-400 leading-relaxed">
              Right-click any connection to change its type
            </p>
          </div>
        </div>

        {/* Edge Context Menu */}
        {contextMenu && (
          <div
            className="fixed z-50 bg-white rounded-lg shadow-2xl border border-slate-200 overflow-hidden min-w-[160px]"
            style={{ top: contextMenu.y, left: contextMenu.x }}
            onClick={(e) => e.stopPropagation()}
          >
            <div className="p-2 border-b border-slate-100 flex items-center gap-2">
              <GitBranch size={12} className="text-slate-500" />
              <span className="text-[10px] font-bold text-slate-500 uppercase">Relation Type</span>
            </div>
            {[
              { type: 'ONE_TO_ONE', label: '1 → 1 (One-to-One)', color: 'purple', description: 'Each record relates to exactly one record' },
              { type: 'ONE_TO_MANY', label: '1 → ∞ (One-to-Many)', color: 'green', description: 'One record relates to many records' },
              { type: 'MANY_TO_ONE', label: '∞ → 1 (Many-to-One)', color: 'blue', description: 'Many records relate to one record' },
              { type: 'MANY_TO_MANY', label: '∞ ↔ ∞ (Many-to-Many)', color: 'amber', description: 'Many records relate to many records' },
            ].map(({ type, label, color, description }) => {
              const colorClasses = {
                purple: 'hover:bg-purple-50 data-[selected=true]:bg-purple-50 data-[selected=true]:text-purple-600',
                green: 'hover:bg-green-50 data-[selected=true]:bg-green-50 data-[selected=true]:text-green-600',
                blue: 'hover:bg-blue-50 data-[selected=true]:bg-blue-50 data-[selected=true]:text-blue-600',
                amber: 'hover:bg-amber-50 data-[selected=true]:bg-amber-50 data-[selected=true]:text-amber-600',
              };
              return (
                <button
                  key={type}
                  onClick={() => updateEdgeRelationType(contextMenu.edge.id, type)}
                  data-selected={contextMenu.edge.data?.relationType === type}
                  className={`w-full text-left px-3 py-2.5 text-xs font-medium transition-colors group ${colorClasses[color as keyof typeof colorClasses]}`}
                  title={description}
                >
                  <div className="font-bold">{label}</div>
                  <div className="text-[10px] text-slate-500 mt-0.5 opacity-0 group-hover:opacity-100 transition-opacity">{description}</div>
                </button>
              );
            })}
            <div className="border-t border-slate-100">
              <button
                onClick={() => deleteEdge(contextMenu.edge.id)}
                className="w-full text-left px-3 py-2 text-xs font-medium text-red-600 hover:bg-red-50 transition-colors flex items-center gap-2"
              >
                <Trash2 size={12} /> Delete Relation
              </button>
            </div>
          </div>
        )}

        {/* Generation Modal */}
        {showModal && (
          <div className="fixed inset-0 z-[100] flex items-center justify-center p-4">
            <div className="absolute inset-0 bg-slate-900/40 backdrop-blur-sm transition-opacity" onClick={() => setShowModal(false)} />
            <div className="glass-card w-full max-w-md p-6 border-none ring-1 ring-white/20 shadow-2xl relative animate-in fade-in zoom-in duration-300">
              <div className="flex items-center justify-between mb-6">
                <div>
                  <h2 className="text-xl font-black text-slate-900 tracking-tight">Generate Project</h2>
                  <p className="text-slate-500 text-xs font-medium">Configure project settings</p>
                </div>
                <div className="p-2 bg-blue-50 text-blue-600 rounded-xl">
                  <Settings size={20} />
                </div>
              </div>

              <div className="space-y-4">
                <div className="grid grid-cols-2 gap-3">
                  <div className="space-y-1">
                    <label className="text-[10px] font-bold text-slate-500 uppercase ml-1">Project Name</label>
                    <input
                      className="w-full bg-slate-50 border border-slate-200 rounded-lg py-2 px-3 text-xs font-bold text-slate-800 focus:ring-2 focus:ring-blue-500/20 focus:border-blue-500 outline-none transition-all"
                      value={projectName}
                      onChange={(e) => setProjectName(e.target.value)}
                    />
                  </div>
                  <div className="space-y-1">
                    <label className="text-[10px] font-bold text-slate-500 uppercase ml-1">Version</label>
                    <input
                      className="w-full bg-slate-50 border border-slate-200 rounded-lg py-2 px-3 text-xs font-medium text-slate-600 focus:ring-2 focus:ring-blue-500/20 focus:border-blue-500 outline-none transition-all"
                      value={version}
                      onChange={(e) => setVersion(e.target.value)}
                    />
                  </div>
                </div>

                <div className="space-y-1">
                  <label className="text-[10px] font-bold text-slate-500 uppercase ml-1">Group ID</label>
                  <input
                    className="w-full bg-slate-50 border border-slate-200 rounded-lg py-2 px-3 text-xs font-medium text-slate-600 focus:ring-2 focus:ring-blue-500/20 focus:border-blue-500 outline-none transition-all"
                    value={groupId}
                    onChange={(e) => setGroupId(e.target.value)}
                  />
                </div>

                <div className="grid grid-cols-2 gap-3">
                  <div className="space-y-1">
                    <label className="text-[10px] font-bold text-slate-500 uppercase ml-1">Language</label>
                    <select
                      className="w-full bg-slate-50 border border-slate-200 rounded-lg py-2 px-3 text-xs font-bold text-slate-800 focus:ring-2 focus:ring-blue-500/20 focus:border-blue-500 outline-none appearance-none cursor-pointer transition-all"
                      value={language}
                      onChange={(e) => setLanguage(e.target.value)}
                    >
                      <option value="JAVA">Java</option>
                      <option value="KOTLIN">Kotlin</option>
                    </select>
                  </div>
                  <div className="space-y-1">
                    <label className="text-[10px] font-bold text-slate-500 uppercase ml-1">Database</label>
                    <select
                      className="w-full bg-slate-50 border border-slate-200 rounded-lg py-2 px-3 text-xs font-bold text-slate-800 focus:ring-2 focus:ring-blue-500/20 focus:border-blue-500 outline-none appearance-none cursor-pointer transition-all"
                      value={dbType}
                      onChange={(e) => setDbType(e.target.value)}
                    >
                      <option value="POSTGRESQL">PostgreSQL</option>
                      <option value="MYSQL">MySQL</option>
                      <option value="H2">H2 (In-Memory)</option>
                    </select>
                  </div>
                </div>
              </div>

              <div className="mt-6 flex gap-2">
                <button
                  onClick={() => setShowModal(false)}
                  className="flex-1 py-2.5 bg-slate-100 hover:bg-slate-200 text-slate-600 font-bold text-sm rounded-xl transition-all"
                >
                  Cancel
                </button>
                <button
                  onClick={triggerGeneration}
                  className="flex-[2] py-2.5 bg-gradient-to-r from-blue-600 to-indigo-600 text-white font-bold text-sm rounded-xl shadow-lg shadow-blue-500/20 hover:shadow-blue-500/40 hover:-translate-y-0.5 transition-all flex items-center justify-center gap-2"
                >
                  <Download size={16} /> Download ZIP
                </button>
              </div>
            </div>
          </div>
        )}
      </main>
    </div>
  );
}