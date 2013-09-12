package br.edu.utfpr.cm.zoomuseu_desktop.util;

import java.util.Enumeration;

import java.util.List;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import br.edu.utfpr.cm.zoomuseu_data.bean.ClasseBean;
import br.edu.utfpr.cm.zoomuseu_data.bean.ClassificacaoBean;
import br.edu.utfpr.cm.zoomuseu_data.bean.EspecieBean;
import br.edu.utfpr.cm.zoomuseu_data.bean.FamiliaBean;
import br.edu.utfpr.cm.zoomuseu_data.bean.FiloBean;
import br.edu.utfpr.cm.zoomuseu_data.bean.GeneroBean;
import br.edu.utfpr.cm.zoomuseu_data.bean.InfraClasseBean;
import br.edu.utfpr.cm.zoomuseu_data.bean.OrdemBean;
import br.edu.utfpr.cm.zoomuseu_data.bean.SubClasseBean;
import br.edu.utfpr.cm.zoomuseu_data.bean.SubEspecieBean;
import br.edu.utfpr.cm.zoomuseu_data.bean.SubFamiliaBean;
import br.edu.utfpr.cm.zoomuseu_data.bean.SubFiloBean;
import br.edu.utfpr.cm.zoomuseu_data.bean.SubGeneroBean;
import br.edu.utfpr.cm.zoomuseu_data.bean.SubOrdemBean;
import br.edu.utfpr.cm.zoomuseu_data.bean.SuperFamiliaBean;
import br.edu.utfpr.cm.zoomuseu_data.bean.TriboBean;
import br.edu.utfpr.cm.zoomuseu_data.bean.VariedadeBean;
import br.edu.utfpr.cm.zoomuseu_data.controller.ControllerFactory;
import br.edu.utfpr.cm.zoomuseu_data.controller.InterfaceFiloController;

public class ConstruirJtree {
	@SuppressWarnings({ "unused" })
	public void atualizarJtree(JTree aTree) {

		DefaultTreeModel jtree = (DefaultTreeModel) aTree.getModel();
		// aTree = new JTree(new DefaultMutableTreeNode("Reino") {
		// });
		DefaultMutableTreeNode tree = (DefaultMutableTreeNode) jtree.getRoot();
		tree.removeAllChildren();
		InterfaceFiloController ifc = ControllerFactory.getInstance()
				.getInterfaceFiloController();
		TreePath aPath = new TreePath((TreeNode) jtree.getRoot());

		List<FiloBean> newFilo = ifc.pesquisar();
		if (tree.getChildCount() == 0) {
			jtree.insertNodeInto(new DefaultMutableTreeNode("Filos"), tree, 0);
		}
		DefaultMutableTreeNode treeFilo = (DefaultMutableTreeNode) jtree
				.getChild(tree, 0);

		for (FiloBean filo : newFilo) {

			DefaultMutableTreeNode FiloNode = (new DefaultMutableTreeNode(filo,
					true));
			jtree.insertNodeInto(FiloNode, treeFilo, treeFilo.getChildCount());
			List<SubFiloBean> subFilos = filo.getSubFilos();

			if (!subFilos.isEmpty()) {
				DefaultMutableTreeNode subFiloFolder = (new DefaultMutableTreeNode(
						"SubFilos", true));
				jtree.insertNodeInto(subFiloFolder, FiloNode,
						FiloNode.getChildCount());
				for (SubFiloBean subFilo : subFilos) {
					DefaultMutableTreeNode subFiloNode = (new DefaultMutableTreeNode(
							subFilo, true));
					jtree.insertNodeInto(subFiloNode, subFiloFolder,
							subFiloFolder.getChildCount());
					List<ClasseBean> Classes = subFilo.getClasses();

					if (!Classes.isEmpty()) {

						DefaultMutableTreeNode ClasseFolder = (new DefaultMutableTreeNode(
								"Classes", true));
						jtree.insertNodeInto(ClasseFolder, subFiloNode,
								subFiloNode.getChildCount());

						for (ClasseBean classe : Classes) {
							DefaultMutableTreeNode ClasseNode = (new DefaultMutableTreeNode(
									classe, true));
							jtree.insertNodeInto(ClasseNode, ClasseFolder,
									ClasseFolder.getChildCount());
							List<SubClasseBean> SubClasses = classe
									.getSubClasses();
							if (!SubClasses.isEmpty()) {

								DefaultMutableTreeNode SubClasseFolder = (new DefaultMutableTreeNode(
										"SubClasses", true));
								jtree.insertNodeInto(SubClasseFolder,
										ClasseNode, ClasseNode.getChildCount());

								for (SubClasseBean subclasse : SubClasses) {
									DefaultMutableTreeNode SubClasseNode = (new DefaultMutableTreeNode(
											subclasse, true));
									jtree.insertNodeInto(SubClasseNode,
											SubClasseFolder,
											SubClasseFolder.getChildCount());
									List<InfraClasseBean> infraClasses = subclasse
											.getInfraClasses();

									if (!infraClasses.isEmpty()) {

										DefaultMutableTreeNode InfraClasseFolder = (new DefaultMutableTreeNode(
												"InfraClasses", true));
										jtree.insertNodeInto(InfraClasseFolder,
												SubClasseNode,
												SubClasseNode.getChildCount());

										for (InfraClasseBean infraClasse : infraClasses) {
											DefaultMutableTreeNode infraClasseNode = (new DefaultMutableTreeNode(
													infraClasse, true));
											jtree.insertNodeInto(
													infraClasseNode,
													InfraClasseFolder,
													InfraClasseFolder
															.getChildCount());
											List<OrdemBean> Ordens = infraClasse
													.getOrdens();
											if (!Ordens.isEmpty()) {

												DefaultMutableTreeNode OrdemFolder = (new DefaultMutableTreeNode(
														"Ordens", true));
												jtree.insertNodeInto(
														OrdemFolder,
														infraClasseNode,
														infraClasseNode
																.getChildCount());

												for (OrdemBean ordem : Ordens) {
													DefaultMutableTreeNode OrdemNode = (new DefaultMutableTreeNode(
															ordem, true));
													jtree.insertNodeInto(
															OrdemNode,
															OrdemFolder,
															OrdemFolder
																	.getChildCount());
													List<SubOrdemBean> subOrdens = ordem
															.getSubOrdens();
													if (!subOrdens.isEmpty()) {

														DefaultMutableTreeNode subOrdemFolder = (new DefaultMutableTreeNode(
																"SubOrdens",
																true));
														jtree.insertNodeInto(
																subOrdemFolder,
																OrdemNode,
																OrdemNode
																		.getChildCount());

														for (SubOrdemBean subordem : subOrdens) {
															DefaultMutableTreeNode SubOrdemNode = (new DefaultMutableTreeNode(
																	subordem,
																	true));
															jtree.insertNodeInto(
																	SubOrdemNode,
																	subOrdemFolder,
																	subOrdemFolder
																			.getChildCount());
															List<SuperFamiliaBean> superFamilias = subordem
																	.getSuperFamilias();
															if (!superFamilias
																	.isEmpty()) {

																DefaultMutableTreeNode SuperFamiliaFolder = (new DefaultMutableTreeNode(
																		"SuperFamilias",
																		true));
																jtree.insertNodeInto(
																		SuperFamiliaFolder,
																		SubOrdemNode,
																		SubOrdemNode
																				.getChildCount());

																for (SuperFamiliaBean supFamilia : superFamilias) {
																	DefaultMutableTreeNode SuperFamiliaNode = (new DefaultMutableTreeNode(
																			supFamilia,
																			true));
																	jtree.insertNodeInto(
																			SuperFamiliaNode,
																			SuperFamiliaFolder,
																			SuperFamiliaFolder
																					.getChildCount());
																	List<FamiliaBean> Familias = supFamilia
																			.getFamilias();
																	if (!Familias
																			.isEmpty()) {

																		DefaultMutableTreeNode FamiliaFolder = (new DefaultMutableTreeNode(
																				"Familias",
																				true));
																		jtree.insertNodeInto(
																				FamiliaFolder,
																				SuperFamiliaNode,
																				SuperFamiliaNode
																						.getChildCount());

																		for (FamiliaBean Familia : Familias) {
																			DefaultMutableTreeNode FamiliaNode = (new DefaultMutableTreeNode(
																					Familia,
																					true));
																			jtree.insertNodeInto(
																					FamiliaNode,
																					FamiliaFolder,
																					FamiliaFolder
																							.getChildCount());
																			List<SubFamiliaBean> SubFamilias = Familia
																					.getSubFamilias();
																			if (!SubFamilias
																					.isEmpty()) {

																				DefaultMutableTreeNode SubFamiliaFolder = (new DefaultMutableTreeNode(
																						"SubFamilias",
																						true));
																				jtree.insertNodeInto(
																						SubFamiliaFolder,
																						FamiliaNode,
																						FamiliaNode
																								.getChildCount());

																				for (SubFamiliaBean SubFamilia : SubFamilias) {
																					DefaultMutableTreeNode SubFamiliaNode = (new DefaultMutableTreeNode(
																							SubFamilia,
																							true));
																					jtree.insertNodeInto(
																							SubFamiliaNode,
																							SubFamiliaFolder,
																							SubFamiliaFolder
																									.getChildCount());
																					List<TriboBean> Tribos = SubFamilia
																							.getTribos();
																					if (!Tribos
																							.isEmpty()) {

																						DefaultMutableTreeNode TriboFolder = (new DefaultMutableTreeNode(
																								"Tribos",
																								true));
																						jtree.insertNodeInto(
																								TriboFolder,
																								SubFamiliaNode,
																								SubFamiliaNode
																										.getChildCount());

																						for (TriboBean Tribo : Tribos) {
																							DefaultMutableTreeNode TriboNode = (new DefaultMutableTreeNode(
																									Tribo,
																									true));
																							jtree.insertNodeInto(
																									TriboNode,
																									TriboFolder,
																									TriboFolder
																											.getChildCount());
																							List<GeneroBean> Generos = Tribo
																									.getGeneros();
																							if (!Generos
																									.isEmpty()) {

																								DefaultMutableTreeNode GeneroFolder = (new DefaultMutableTreeNode(
																										"Generos",
																										true));
																								jtree.insertNodeInto(
																										GeneroFolder,
																										TriboNode,
																										TriboNode
																												.getChildCount());

																								for (GeneroBean Genero : Generos) {
																									DefaultMutableTreeNode GeneroNode = (new DefaultMutableTreeNode(
																											Genero,
																											true));
																									jtree.insertNodeInto(
																											GeneroNode,
																											GeneroFolder,
																											GeneroFolder
																													.getChildCount());
																									List<SubGeneroBean> SubGeneros = Genero
																											.getSubGeneros();

																									if (!SubGeneros
																											.isEmpty()) {

																										DefaultMutableTreeNode SubGeneroFolder = (new DefaultMutableTreeNode(
																												"SubGeneros",
																												true));
																										jtree.insertNodeInto(
																												SubGeneroFolder,
																												GeneroNode,
																												GeneroNode
																														.getChildCount());

																										for (SubGeneroBean SubGenero : SubGeneros) {
																											DefaultMutableTreeNode SubGeneroNode = (new DefaultMutableTreeNode(
																													SubGenero,
																													true));
																											jtree.insertNodeInto(
																													SubGeneroNode,
																													SubGeneroFolder,
																													SubGeneroFolder
																															.getChildCount());
																											List<EspecieBean> Especies = SubGenero
																													.getEspecies();
																											if (!Especies
																													.isEmpty()) {

																												DefaultMutableTreeNode EspecieFolder = (new DefaultMutableTreeNode(
																														"Especies",
																														true));
																												jtree.insertNodeInto(
																														EspecieFolder,
																														SubGeneroNode,
																														SubGeneroNode
																																.getChildCount());

																												for (EspecieBean Especie : Especies) {
																													DefaultMutableTreeNode EspecieNode = (new DefaultMutableTreeNode(
																															Especie,
																															true));
																													jtree.insertNodeInto(
																															EspecieNode,
																															EspecieFolder,
																															EspecieFolder
																																	.getChildCount());
																													List<SubEspecieBean> SubEspecies = Especie
																															.getSubEspecies();
																													if (!SubEspecies
																															.isEmpty()) {

																														DefaultMutableTreeNode SubEspecieFolder = (new DefaultMutableTreeNode(
																																"SubEspecies",
																																true));
																														jtree.insertNodeInto(
																																SubEspecieFolder,
																																EspecieNode,
																																EspecieNode
																																		.getChildCount());

																														for (SubEspecieBean SubEspecie : SubEspecies) {
																															DefaultMutableTreeNode SubEspecieNode = (new DefaultMutableTreeNode(
																																	SubEspecie,
																																	true));
																															jtree.insertNodeInto(
																																	SubEspecieNode,
																																	SubEspecieFolder,
																																	SubEspecieFolder
																																			.getChildCount());
																															List<VariedadeBean> Variedades = SubEspecie
																																	.getVariedades();

																															if (!Variedades
																																	.isEmpty()) {

																																DefaultMutableTreeNode VariedadeFolder = (new DefaultMutableTreeNode(
																																		"Variedades",
																																		true));
																																jtree.insertNodeInto(
																																		VariedadeFolder,
																																		SubEspecieNode,
																																		SubEspecieNode
																																				.getChildCount());

																																for (VariedadeBean Variedade : Variedades) {
																																	DefaultMutableTreeNode VariedadeNode = (new DefaultMutableTreeNode(
																																			Variedade,
																																			true));
																																	jtree.insertNodeInto(
																																			VariedadeNode,
																																			VariedadeFolder,
																																			VariedadeFolder
																																					.getChildCount());

																																}
																															}
																														}
																													}
																												}

																											}
																										}
																									}
																								}
																							}
																						}
																					}
																				}
																			}
																		}
																	}
																}
															}

														}
													}
												}
											}
										}
									}
								}
							}
						}
					}

				}
				jtree.reload();
				aTree.setModel(jtree);
				aTree.updateUI();
				// expandJTree(aTree, -1);

			}
		}
	}

	public static void expandJTree(javax.swing.JTree tree, int depth) {
		javax.swing.tree.TreeModel model = tree.getModel();
		expandJTreeNode(tree, model, model.getRoot(), 0, depth);
	} // expandJTree()

	public DefaultMutableTreeNode pesquisarTermo(String nodeStr,
			javax.swing.JTree tree) {
		DefaultMutableTreeNode node = null;

		// Get the enumeration
		@SuppressWarnings("unchecked")
		Enumeration<DefaultMutableTreeNode> enums = ((DefaultMutableTreeNode) tree.getModel().getRoot())
				.breadthFirstEnumeration();

		// iterate through the enumeration
		while (enums.hasMoreElements()) {
			// get the node
			node = (DefaultMutableTreeNode) enums.nextElement();

			// match the string with the user-object of the node
			if (nodeStr.equals(node.getUserObject().toString())) {
				// tree node with string found
				return node;
			}
		}

		// tree node with string node found return null
		return null;
	}

	public ClassificacaoBean construirClassificacao(JTree aTree) {
		DefaultTreeModel jtree = (DefaultTreeModel) aTree.getModel();
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) aTree
				.getLastSelectedPathComponent();

		ClassificacaoBean classBean = new ClassificacaoBean();

		if(node != null){
		TreeNode[] pathToRoot = jtree
				.getPathToRoot(node);
		if(node.getUserObject() instanceof FiloBean ||node.getUserObject() instanceof SubFiloBean || node.toString().equals("Classes")
				|| node.toString().equals("Filos")|| node.toString().equals("SubFilos")|| node.toString().equals("Reino")){
			return null;
		}
		
		for (TreeNode taxon : pathToRoot) {
			DefaultMutableTreeNode aTaxon  = (DefaultMutableTreeNode) taxon;
			if (aTaxon.getUserObject() instanceof FiloBean) {
				classBean.setFilo((FiloBean)aTaxon.getUserObject());
				
			}else if (aTaxon.getUserObject() instanceof SubFiloBean) {
				classBean.setSubFilo((SubFiloBean)aTaxon.getUserObject());
			
			}
			else if (aTaxon.getUserObject() instanceof ClasseBean) {
				classBean.setClasse((ClasseBean)aTaxon.getUserObject());
			}else if (aTaxon.getUserObject() instanceof SubClasseBean) {
				classBean.setSubClasse((SubClasseBean)aTaxon.getUserObject());
			}else if (aTaxon.getUserObject() instanceof InfraClasseBean) {
				classBean.setInfraClasse((InfraClasseBean)aTaxon.getUserObject());
			}else if (aTaxon.getUserObject() instanceof OrdemBean) {
				classBean.setOrdem((OrdemBean)aTaxon.getUserObject());
			}else if (aTaxon.getUserObject() instanceof SuperFamiliaBean) {
				classBean.setSuperFamilia((SuperFamiliaBean)aTaxon.getUserObject());
			}else if (aTaxon.getUserObject() instanceof FamiliaBean) {
				classBean.setFamilia((FamiliaBean)aTaxon.getUserObject());
			}else if (aTaxon.getUserObject() instanceof SubOrdemBean) {
				classBean.setSubOrdem((SubOrdemBean)aTaxon.getUserObject());
			}else if (aTaxon.getUserObject() instanceof SubFamiliaBean) {
				classBean.setSubFamilia((SubFamiliaBean)aTaxon.getUserObject());
			}else if (aTaxon.getUserObject() instanceof TriboBean) {
				classBean.setTribo((TriboBean)aTaxon.getUserObject());
			}else if (aTaxon.getUserObject() instanceof GeneroBean) {
				classBean.setGenero((GeneroBean)aTaxon.getUserObject());
			}else if (aTaxon.getUserObject() instanceof SubGeneroBean) {
				classBean.setSubGenero((SubGeneroBean)aTaxon.getUserObject());
			}else if (aTaxon.getUserObject() instanceof EspecieBean) {
				classBean.setEspecie((EspecieBean)aTaxon.getUserObject());
			}else if (aTaxon.getUserObject() instanceof SubEspecieBean) {
				classBean.setSubEspecie((SubEspecieBean)aTaxon.getUserObject());
			}else if (aTaxon.getUserObject() instanceof VariedadeBean) {
				classBean.setVariedade((VariedadeBean)aTaxon.getUserObject());
			}
		
		}
			
		}
	
		return classBean;
	}

	public static int expandJTreeNode(javax.swing.JTree tree,
			javax.swing.tree.TreeModel model, Object node, int row, int depth) {
		if (node != null && !model.isLeaf(node)) {
			tree.expandRow(row);
			if (depth != 0) {
				for (int index = 0; row + 1 < tree.getRowCount()
						&& index < model.getChildCount(node); index++) {
					row++;
					Object child = model.getChild(node, index);
					if (child == null)
						break;
					javax.swing.tree.TreePath path;
					while ((path = tree.getPathForRow(row)) != null
							&& path.getLastPathComponent() != child)
						row++;
					if (path == null)
						break;
					row = expandJTreeNode(tree, model, child, row, depth - 1);
				}
			}
		}
		return row;
	}
}
