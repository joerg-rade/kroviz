package org.ro.layout

import kotlinx.serialization.Serializable
import org.ro.to.Link

@Serializable
data class CollectionLayout(var named: String? = "",
                            var describedAs: String? = "",
                            var sortedBy: String? = "",
                            var metadataError: String? = "",
                            var link: Link? = null,
                            var id: String? = "",
                            var cssClass: String? = "",
                            var defaultView: String? = null,
                            var hidden: String? = null,
                            var namedEscaped: String? = "",
                            var paged: String? = ""
)
