/*
 * Copyright © 2019 IBM Corp. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */

package com.cloudant.client.api.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by samsmith on 24/01/2019.
 */
public class PartitionInfo {

    public static class Indexes {

        private long search;
        private long view;


        /**
         * Get a count of the partitioned search indexes.
         *
         * @return The partitioned search index count.
         */
        public long getSearch() {
            return search;
        }


        /**
         * Get a count of the partitioned view indexes.
         *
         * @return The partitioned view index count.
         */
        public long getView() {
            return view;
        }

    }

    public static class PartitionedIndexes {

        private long count;
        private long limit;
        private Indexes indexes;

        /**
         * Get a total count of the partitioned indexes.
         *
         * @return The total partitioned index count.
         */
        public long getCount() {
            return count;
        }

        /**
         * Get the partitioned index limit.
         *
         * @return The partitioned index limit.
         */
        public long getLimit() {
            return limit;
        }

        /**
         * Get the {@link com.cloudant.client.api.model.PartitionInfo.Indexes} object for this
         * database partition.
         *
         * @return The {@link com.cloudant.client.api.model.PartitionInfo.Indexes} object,
         * containing the count breakdown of partitioned indexes.
         */
        public Indexes getIndexes() {
            return indexes;
        }

    }

    public static class Sizes {

        private long active;
        private long external;

        /**
         * Get the size of live data inside the database, in bytes.
         *
         * @return The size of live data in bytes.
         */
        public long getActive() {
            return active;
        }

        /**
         * Get the uncompressed size of database contents, in bytes.
         *
         * @return The uncompressed size of database contents in bytes.
         */
        public long getExternal() {
            return external;
        }

    }

    @SerializedName("doc_count")
    private long docCount;
    @SerializedName("doc_del_count")
    private long docDelCount;
    private String partition;
    @SerializedName("partitioned_indexes")
    private PartitionedIndexes partitionedIndexes;
    private Sizes sizes;

    /**
     * Get a count of the documents in the specified database partition.
     *
     * @return The document count.
     */
    public long getDocCount() {
        return docCount;
    }

    /**
     * Get a count of the deleted documents in the specified database partition.
     *
     * @return The deleted document count.
     */
    public long getDocDelCount() {
        return docDelCount;
    }

    /**
     * Get the database partition key.
     *
     * @return The database partition key.
     */
    public String getPartition() {
        return partition;
    }

    /**
     * Get the {@link com.cloudant.client.api.model.PartitionInfo.PartitionedIndexes} object for
     * this database partition.
     *
     * @return The {@link com.cloudant.client.api.model.PartitionInfo.PartitionedIndexes} object,
     * containing metadata about partitioned indexes in this database partition.
     */
    public PartitionedIndexes getPartitionedIndexes() {
        return partitionedIndexes;
    }

    /**
     * Get the {@link com.cloudant.client.api.model.PartitionInfo.Sizes} object for this database
     * partition.
     *
     * @return The {@link com.cloudant.client.api.model.PartitionInfo.Sizes} object, containing data
     * size information for this database partition.
     */
    public Sizes getSizes() {
        return sizes;
    }

    @Override
    public String toString() {
        return String.format("PartitionInfo [docCount=%s, docDelCount=%s, partition=%s, " +
                        "sizes=Sizes [external=%s, active=%s]]",
                        docCount, docDelCount, partition, sizes.getActive(), sizes.getExternal());
    }

}
